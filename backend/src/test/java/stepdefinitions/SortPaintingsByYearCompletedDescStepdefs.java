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

public class SortPaintingsByYearCompletedDescStepdefs {
    RestClient restClient;

    String uriBase;

    List<PaintingDTO> paintings;
    @Given("I have a sort paintings by year completed desc Spring endpoint")
    public void iHaveASortPaintingsByYearCompletedDescSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }

    @When("I call the sort paintings by year completed desc endpoint")
    public void iCallTheSortPaintingsByYearCompletedDescEndpoint() {
        paintings = restClient.get()
                .uri(uriBase + "/paintings/sortAllByYearCompleted/desc")
                .retrieve()
                .body(new ParameterizedTypeReference<List<PaintingDTO>>() {});
    }

    @Then("I should get back a list of paintings sorted by year completed desc")
    public void iShouldGetBackAListOfPaintingsSortedByYearCompletedDesc() {
        Assertions.assertNotNull(paintings);
    }

    @And("each item should returned in descending year completed order and contain the {string}, {int} and {string} of the paintings at a given {int}")
    public void eachItemShouldReturnedInDescendingYearCompletedOrderAndContainTheTitleYear_CompletedAndArtist_NameOfThePaintingsAtAGivenIndex(String title, int yearCompleted, String artistName, int index) {
        Assertions.assertAll("Testing painting information retrieval",
                () -> Assertions.assertEquals(title, paintings.get(index).getTitle()),
                () -> Assertions.assertEquals(yearCompleted, paintings.get(index).getYearCompleted()),
                () -> Assertions.assertEquals(artistName, paintings.get(index).getArtistName())
        );
    }
}
