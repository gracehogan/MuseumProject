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
