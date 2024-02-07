package stepdefinitions;

import com.barclays.controller.ArtistController;
import com.barclays.model.Artist;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class GetArtistByIdStepdefs {

    @Autowired
    ArtistController artistController;

    Artist artist;

    @Given("I have a get artist by id Spring endpoint")
    public void iHaveAGetArtistByIdSpringEndpoint() {
        Assertions.assertNotNull(artistController);
    }

    @When("I call the get artist by {int} endpoint")
    public void iCallTheGetArtistByIdEndpoint(int id) {
        artist = artistController.getArtistById((long) id);
    }

    @Then("I should get back the {string}, {int} and {int} of the artist")
    public void iShouldGetBackTheNameYear_Of_BirthAndYear_Of_DeathOfTheArtist(String name, int birthYear, int deathYear) {
        Assertions.assertAll("Testing artist information retrieval",
                () -> Assertions.assertEquals(name, artist.getName()),
                () -> Assertions.assertEquals(birthYear, artist.getYearOfBirth()),
                () -> Assertions.assertEquals(deathYear, artist.getYearOfDeath())
        );
    }
}
