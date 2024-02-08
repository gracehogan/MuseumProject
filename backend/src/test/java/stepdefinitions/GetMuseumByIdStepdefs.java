package stepdefinitions;

import com.barclays.controller.MuseumController;
import com.barclays.dto.MuseumDTO;
import com.barclays.dto.PaintingDTO;
import com.barclays.model.Museum;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;

public class GetMuseumByIdStepdefs {

    RestClient restClient;
    String uriBase;

    MuseumDTO museum;

    @Given("I have a get museum by id Spring endpoint")
    public void iHaveAGetMuseumByIdSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }

    @When("I call the get museum by {int} endpoint")
    public void iCallTheGetMuseumByIdEndpoint(int id) {
        museum = restClient.get()
                .uri(uriBase + "/museums/" + id)
                .retrieve()
                .body(MuseumDTO.class);
    }

    @Then("I should get back the {string}, {string} and {string} of the museum")
    public void iShouldGetBackTheNameLocationAndCuratorOfTheMuseum(String name, String location, String curator) {
        Assertions.assertAll("Testing artist information retrieval",
                () -> Assertions.assertEquals(name, museum.getName()),
                () -> Assertions.assertEquals(location, museum.getLocation()),
                () -> Assertions.assertEquals(curator, museum.getCurator())
        );
    }
}
