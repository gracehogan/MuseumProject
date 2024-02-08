package stepdefinitions;

import com.barclays.controller.ArtistController;
import com.barclays.dto.ArtistDTO;
import com.barclays.dto.MuseumDTO;
import com.barclays.model.Artist;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class GetAllArtistsStepdefs {

    RestClient restClient;
    String uriBase;
    List<ArtistDTO> artists;

    @Given("I have a get all artists Spring endpoint")
    public void iHaveAGetAllArtistsSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();

    }

    @When("I call the get all artists endpoint")
    public void iCallTheGetAllArtistsEndpoint() {
        artists = restClient.get()
                .uri(uriBase + "/artist")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ArtistDTO>>() {});
    }

    @Then("I should get back a list of artists")
    public void iShouldGetBackAListOfArtists() {
        Assertions.assertNotNull(artists);
    }

    @And("each item should contain the {string}, {int} and {int} of the artist at a given {int}")
    public void eachItemShouldContainTheNameYear_Of_BirthAndYear_Of_DeathOfTheArtistAtAGivenIndex(String name, int birthYear, int deathYear, int index) {
        Assertions.assertAll("Testing artist information retrieval",
                () -> Assertions.assertEquals(name, artists.get(index).getName()),
                () -> Assertions.assertEquals(birthYear, artists.get(index).getYearOfBirth()),
                () -> Assertions.assertEquals(deathYear, artists.get(index).getYearOfDeath())
        );
    }
}
