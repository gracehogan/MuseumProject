package stepdefinitions;

import com.barclays.controller.SculptureController;
import com.barclays.dto.PaintingDTO;
import com.barclays.dto.SculptureDTO;
import com.barclays.model.Sculpture;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;

public class GetSculptureByIdStepdefs {

    RestClient restClient;
    String uriBase;
    SculptureDTO sculpture;

    @Given("I have a get sculpture by id Spring endpoint")
    public void iHaveAGetSculptureByIdSpringEndpoint(){
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();

    }

    @When("I call the get sculpture by {int} endpoint")
    public void iCallTheGetSculptureByIdEndpoint(int id) {
        sculpture = restClient.get()
                .uri(uriBase + "/sculptures/" + id)
                .retrieve()
                .body(SculptureDTO.class);
    }

    @Then("I should get back the {string}, {int} and {string} of the sculpture")
    public void iShouldGetBackTheTitleYear_CompletedAndMediumOfTheSculpture(String title, int yearCompleted, String medium) {
        Assertions.assertAll("Testing sculpture information retrieval",
                () -> Assertions.assertEquals(title, sculpture.getTitle()),
                () -> Assertions.assertEquals(yearCompleted, sculpture.getYearCompleted()),
                () -> Assertions.assertEquals(medium, sculpture.getMedium())
        );
    }
}
