package stepdefinitions;

import com.barclays.dto.SculptureDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class SortSculpturesByTitleDescStepdefs {
    RestClient restClient;

    String uriBase;

    List<SculptureDTO> sculptures;

    @Given("I have a sort sculptures by title desc Spring endpoint")
    public void iHaveASortSculpturesByTitleDescSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }

    @When("I call the sort sculptures by title desc endpoint")
    public void iCallTheSortSculpturesByTitleDescEndpoint() {
        sculptures = restClient.get()
                .uri(uriBase + "/sculptures/sortAllByTitle/desc")
                .retrieve()
                .body(new ParameterizedTypeReference<List<SculptureDTO>>() {});
    }

    @Then("I should get back a list of sculptures sorted by title desc")
    public void iShouldGetBackAListOfSculpturesSortedByTitleDesc() {
        Assertions.assertNotNull(sculptures);
    }

    @And("each item should returned in descending title order and contain the {string}, {int} and {string} of the sculptures at a given {int}")
    public void eachItemShouldReturnedInDescendingTitleOrderAndContainTheTitleYear_CompletedAndArtist_NameOfTheSculpturesAtAGivenIndex(String title, int yearCompleted, String artistName, int index) {
        Assertions.assertAll("Testing sculpture information retrieval",
                () -> Assertions.assertEquals(title, sculptures.get(index).getTitle()),
                () -> Assertions.assertEquals(yearCompleted, sculptures.get(index).getYearCompleted()),
                () -> Assertions.assertEquals(artistName, sculptures.get(index).getArtistName())
        );

    }
}
