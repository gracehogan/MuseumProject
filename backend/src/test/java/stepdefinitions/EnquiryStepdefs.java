package stepdefinitions;

import com.barclays.dto.EnquiryDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnquiryStepdefs {
    RestClient restClient;
    String uriBase;

    EnquiryDTO enquiryDTO;
    @Given("I have a Rest Spring {string}")
    public void iHaveARestSpringEndpoint(String endpoint) {
        uriBase = endpoint;
        restClient = RestClient.create();
    }

    @When("I send an enquiry calling  {string} {string} {string} {string}")
    public void iSendAnEnquiryCallingNameEmailEnquiryTypeEnquiryText(String name,String email,String enquiryType,String enquiryText) {
        enquiryDTO = restClient.post()
                .uri(uriBase + "/" + name+ "/" +email+ "/" +enquiryType+ "/" +enquiryText)
                .retrieve()
                .body(EnquiryDTO.class);
    }

    @Then("I should get the {string} {string} {string} {string} of the customer")
    public void iShouldGetTheNameEmailEnquiryTypeEnquiryTextOfTheCustomer(String name,String email,String enquiryType,String enquiryText) {
        assertAll("Test send enquiry",
                () -> assertEquals(name, enquiryDTO.getName()),
                () -> assertEquals(email, enquiryDTO.getEmail()),
                () -> assertEquals(enquiryType, enquiryDTO.getEnquiryType()),
                () -> assertEquals(enquiryText, enquiryDTO.getEnquiryText())
        );
    }
}
//  /sendEnquiry/{name}/{email}/{enquiryType}/{enquiryText}
//
//
//public class GetMuseumByIdStepdefs {
//

//
//    @Given("I have a get museum by id Spring endpoint")
//    public void iHaveAGetMuseumByIdSpringEndpoint() {
//        uriBase = "http://localhost:8080";
//        restClient = RestClient.create();
//    }
//
//    @When("I call the get museum by {int} endpoint")
//    public void iCallTheGetMuseumByIdEndpoint(int id) {
//        museum = restClient.get()
//                .uri(uriBase + "/museums/" + id)
//                .retrieve()
//                .body(MuseumDTO.class);
//    }
//
//    @Then("I should get back the {string}, {string} and {string} of the museum")
//    public void iShouldGetBackTheNameLocationAndCuratorOfTheMuseum(String name, String location, String curator) {
//        Assertions.assertAll("Testing artist information retrieval",
//                () -> Assertions.assertEquals(name, museum.getName()),
//                () -> Assertions.assertEquals(location, museum.getLocation()),
//                () -> Assertions.assertEquals(curator, museum.getCurator())
//        );
//    }
//}