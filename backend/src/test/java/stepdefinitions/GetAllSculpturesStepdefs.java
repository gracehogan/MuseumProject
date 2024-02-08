package stepdefinitions;

import com.barclays.dto.PaintingDTO;
import com.barclays.dto.SculptureDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class GetAllSculpturesStepdefs {

    RestClient restClient;

    String uriBase;

    List<SculptureDTO> sculptures;
    @Given("I have a get all sculptures Spring endpoint")
    public void iHaveAGetAllSculpturesSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }

    @When("I call the get all sculptures endpoint")
    public void iCallTheGetAllSculpturesEndpoint() {
        sculptures = restClient.get()
                .uri(uriBase + "/sculptures")
                .retrieve()
                .body(new ParameterizedTypeReference<List<SculptureDTO>>() {});
    }

    @Then("I should get back a list of sculptures")
    public void iShouldGetBackAListOfSculptures() {
        Assertions.assertNotNull(sculptures);
    }

    @And("each item should contain the {string}, {int} and {string} of the sculptures at a given {int}")
    public void eachItemShouldContainTheTitleYear_CompletedAndMediumOfTheSculpturesAtAGivenIndex(String title, int yearCompleted, String medium, int index) {
        Assertions.assertAll("Testing sculpture information retrieval",
                () -> Assertions.assertEquals(title, sculptures.get(index).getTitle()),
                () -> Assertions.assertEquals(yearCompleted, sculptures.get(index).getYearCompleted()),
                () -> Assertions.assertEquals(medium, sculptures.get(index).getMedium())
        );

    }
}
