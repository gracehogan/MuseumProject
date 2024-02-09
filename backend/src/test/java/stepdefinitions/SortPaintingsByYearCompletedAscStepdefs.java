package stepdefinitions;

import com.barclays.dto.PaintingDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class SortPaintingsByYearCompletedAscStepdefs {

    RestClient restClient;

    String uriBase;

    List<PaintingDTO> paintings;
    @Given("I have a sort paintings by year completed asc Spring endpoint")
    public void iHaveASortPaintingsByYearCompletedAscSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }

    @When("I call the sort paintings by year completed asc endpoint")
    public void iCallTheSortPaintingsByYearCompletedAscEndpoint() {
        paintings = restClient.get()
                .uri(uriBase + "/paintings/sortAllByYearCompleted/asc")
                .retrieve()
                .body(new ParameterizedTypeReference<List<PaintingDTO>>() {});
    }

    @Then("I should get back a list of paintings sorted by year completed asc")
    public void iShouldGetBackAListOfPaintingsSortedByYearCompletedAsc() {
        Assertions.assertNotNull(paintings);
    }

    @And("each item should returned in ascending year completed order and contain the {string}, {int} and {string} of the paintings at a given {int}")
    public void eachItemShouldReturnedInAscendingYearCompletedOrderAndContainTheTitleYear_CompletedAndArtist_NameOfThePaintingsAtAGivenIndex(String title, int yearCompleted, String artistName, int index) {
        Assertions.assertAll("Testing painting information retrieval",
                () -> Assertions.assertEquals(title, paintings.get(index).getTitle()),
                () -> Assertions.assertEquals(yearCompleted, paintings.get(index).getYearCompleted()),
                () -> Assertions.assertEquals(artistName, paintings.get(index).getArtistName())
        );
    }
}
