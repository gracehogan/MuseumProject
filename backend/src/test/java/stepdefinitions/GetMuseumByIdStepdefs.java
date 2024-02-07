package stepdefinitions;

import com.barclays.controller.MuseumController;
import com.barclays.model.Museum;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class GetMuseumByIdStepdefs {
    @Autowired
    MuseumController museumController;

    Museum museum;

    @Given("I have a get museum by id Spring endpoint")
    public void iHaveAGetMuseumByIdSpringEndpoint() {
        Assertions.assertNotNull(museumController);
    }

    @When("I call the get museum by {int} endpoint")
    public void iCallTheGetMuseumByIdEndpoint(int id) {
        museum = museumController.getMuseum((long) id);
    }

    @Then("I should get back the {string}, {string} and {string} of the museum")
    public void iShouldGetBackTheNameLocationAndCuratorOfTheMuseum(String name, String location, String curator) {
        Assertions.assertAll("Testing artist information retrieval",
                () -> Assertions.assertEquals(name, museum.getName()),
                () -> Assertions.assertEquals(location, museum.getLocation()),
                () -> Assertions.assertEquals(curator, museum.getCurator())
        );
    }
}
