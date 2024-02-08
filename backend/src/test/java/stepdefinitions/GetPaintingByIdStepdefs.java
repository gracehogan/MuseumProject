package stepdefinitions;

import com.barclays.dto.PaintingDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestClient;

public class GetPaintingByIdStepdefs {


    RestClient restClient;

    String uriBase;
    PaintingDTO painting;

    @Given("I have a get painting by id Spring endpoint")
    public void iHaveAGetPaintingByIdSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();

    }

    @When("I call the get painting by {int} endpoint")
    public void iCallTheGetPaintingByIdEndpoint(int id) {
        painting = restClient.get()
                .uri(uriBase + "/paintings/getById/" + id)
                .retrieve()
                .body(PaintingDTO.class);
    }

    @Then("I should get back the {string}, {int} and {string} of the painting")
    public void iShouldGetBackTheTitleYear_CompletedAndArtist_NameOfThePainting(String title, int yearCompleted, String artistName) {
        Assertions.assertAll("Testing painting information retrieval",
                () -> Assertions.assertEquals(title, painting.getTitle()),
                () -> Assertions.assertEquals(yearCompleted, painting.getYearCompleted()),
                () -> Assertions.assertEquals(artistName, painting.getArtistName())
        );
    }
}
