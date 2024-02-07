package stepdefinitions;

import com.barclays.controller.PaintingController;
import com.barclays.dto.PaintingDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class GetPaintingByIdStepdefs {

    @Autowired
    PaintingController paintingController;

    PaintingDTO painting;

    @Given("I have a get painting by id Spring endpoint")
    public void iHaveAGetPaintingByIdSpringEndpoint() {
        Assertions.assertNotNull(paintingController);
    }

    @When("I call the get painting by {int} endpoint")
    public void iCallTheGetPaintingByIdEndpoint(int id) {
        painting = paintingController.getPainting(id);
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
