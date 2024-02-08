package stepdefinitions;

import com.barclays.controller.MuseumController;
import com.barclays.dto.ArtistDTO;
import com.barclays.dto.MuseumDTO;
import com.barclays.model.Museum;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class GetAllMuseumsStepdefs {

    RestClient restClient;

    String uriBase;


    List<MuseumDTO> museums;

    @Given("I have a get all museums Spring endpoint")
    public void iHaveAGetAllMuseumsSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }

    @When("I call the get all museums endpoint")
    public void iCallTheGetAllMuseumsEndpoint() {
        museums = restClient.get()
                .uri(uriBase + "/museums")
                .retrieve()
                .body(new ParameterizedTypeReference<List<MuseumDTO>>() {});
    }

    @Then("I should get back a list of museums")
    public void iShouldGetBackAListOfMuseums() {
        Assertions.assertNotNull(museums);
    }

    @And("each item should contain the {string}, {string} and {string} of the museum at a given {int}")
    public void eachItemShouldContainTheNameLocationAndCuratorOfTheMuseum(String name, String location, String curator, int index) {
        Assertions.assertAll("Testing artist information retrieval",
                () -> Assertions.assertEquals(name, museums.get(index).getName()),
                () -> Assertions.assertEquals(location, museums.get(index).getLocation()),
                () -> Assertions.assertEquals(curator, museums.get(index).getCurator())
        );
    }
}
