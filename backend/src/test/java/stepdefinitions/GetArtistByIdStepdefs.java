package stepdefinitions;

import com.barclays.controller.ArtistController;
import com.barclays.dto.ArtistDTO;
import com.barclays.dto.PaintingDTO;
import com.barclays.model.Artist;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;

public class GetArtistByIdStepdefs {

    RestClient restClient;

    String uriBase;

    ArtistDTO artist;

    @Given("I have a get artist by id Spring endpoint")
    public void iHaveAGetArtistByIdSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }

    @When("I call the get artist by {int} endpoint")
    public void iCallTheGetArtistByIdEndpoint(int id) {
        artist = restClient.get()
                .uri(uriBase + "/artist/" + id)
                .retrieve()
                .body(ArtistDTO.class);
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
