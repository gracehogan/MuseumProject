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

public class SortSculpturesByYearCompletedAsc {

    RestClient restClient;

    String uriBase;

    List<SculptureDTO> sculptures;
    @Given("I have a sort sculptures by year completed asc Spring endpoint")
    public void iHaveASortSculpturesByYearCompletedAscSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }

    @When("I call the sort sculptures by year completed asc endpoint")
    public void iCallTheSortSculpturesByYearCompletedAscEndpoint() {
        sculptures = restClient.get()
                .uri(uriBase + "/sculptures/sortAllByYearCompleted/asc")
                .retrieve()
                .body(new ParameterizedTypeReference<List<SculptureDTO>>() {});
    }

    @Then("I should get back a list of sculptures sorted by year completed asc")
    public void iShouldGetBackAListOfSculpturesSortedByYearCompletedAsc() {
        Assertions.assertNotNull(sculptures);
    }

    @And("each item should returned in ascending year completed order and contain the {string}, {int} and {string} of the sculptures at a given {int}")
    public void eachItemShouldReturnedInAscendingYearCompletedOrderAndContainTheTitleYear_CompletedAndArtist_NameOfTheSculpturesAtAGivenIndex(String title, int yearCompleted, String artistName, int index) {
        Assertions.assertAll("Testing sculpture information retrieval",
                () -> Assertions.assertEquals(title, sculptures.get(index).getTitle()),
                () -> Assertions.assertEquals(yearCompleted, sculptures.get(index).getYearCompleted()),
                () -> Assertions.assertEquals(artistName, sculptures.get(index).getArtistName())
        );


    }

}
