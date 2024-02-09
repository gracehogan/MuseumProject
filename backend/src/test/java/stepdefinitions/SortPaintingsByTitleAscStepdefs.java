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

public class SortPaintingsByTitleAscStepdefs {

    RestClient restClient;

    String uriBase;

    List<PaintingDTO> paintings;
    @Given("I have a sort paintings by title asc Spring endpoint")
    public void iHaveASortPaintingsByTitleAscSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }

    @When("I call the sort paintings by title asc endpoint")
    public void iCallTheSortPaintingsByTitleAscEndpoint() {
        paintings = restClient.get()
                .uri(uriBase + "/paintings/sortAllByTitle/asc")
                .retrieve()
                .body(new ParameterizedTypeReference<List<PaintingDTO>>() {});
    }

    @Then("I should get back a list of paintings sorted by title asc")
    public void iShouldGetBackAListOfPaintingsSortedByTitleAsc() {
        Assertions.assertNotNull(paintings);
    }

    @And("each item should returned in ascending title order and contain the {string}, {int} and {string} of the paintings at a given {int}")
    public void eachItemShouldReturnedInAscendingTitleOrderAndContainTheTitleYear_CompletedAndArtist_NameOfThePaintingsAtAGivenIndex(String title, int yearCompleted, String artistName, int index) {
        Assertions.assertAll("Testing painting information retrieval",
                () -> Assertions.assertEquals(title, paintings.get(index).getTitle()),
                () -> Assertions.assertEquals(yearCompleted, paintings.get(index).getYearCompleted()),
                () -> Assertions.assertEquals(artistName, paintings.get(index).getArtistName())
        );
    }
}
