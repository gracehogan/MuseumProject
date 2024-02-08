package stepdefinitions;


import com.barclays.dto.BookingDTO;
import com.barclays.dto.EnquiryDTO;
import com.barclays.model.enums.BookedMuseum;
import com.barclays.model.enums.BookingType;
import com.barclays.repository.BookingRepository;
import com.barclays.service.BookingService;
import com.barclays.service.BookingServiceImpl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;


public class BookingStepDefs {
    private List<Map<String, String>> availableMuseums;
    private List<Map<String, String>> availableTickets;
    private List<Map<String, String>> registeredBookings;


    BookingRepository bookingRepository;
    BookingService service = new BookingServiceImpl(bookingRepository);

    BookingDTO booking, newBooking1,newBooking2;

    RestClient restClient;
    String uriBase;
    @Given("the following museum are available to book")
    public void theFollowingMuseumAreAvailableToBook(DataTable museumTable) {
        this.availableMuseums = museumTable.asMaps(String.class, String.class);
    }

    private BookingDTO findBooking(String name) {
        for (Map<String, String> registeredBooking : registeredBookings) {
            if (registeredBooking.get("Name").equals(name)) {
                booking = new BookingDTO();
                booking.setName(name);
                booking.setEmail(registeredBooking.get("Email"));
                booking.setBookingSlot(registeredBooking.get("Slot"));
                return booking;
            }
        }
        throw new RuntimeException(name + " has no bookings !!");
    }


    @Given("I am a registered user with a booking")
    public void iAmARegisteredUserWithABooking(DataTable bookingTable) {
        this.registeredBookings = bookingTable.asMaps(String.class, String.class);


    }

    @When("{string} books a visit to  {string} with {string} for {string}")
    public void nameBooksAVisitToMuseumsWithTicketTypeForPersons(String name, String museums, String ticket, String persons) {
        newBooking1 = findBooking(name);
        newBooking1.setBookingType(findTicket(ticket));
        newBooking1.setNumberOfPersons(Integer.parseInt(persons));
        newBooking1.setBookedMuseum(findMuseum(museums));
    }


    @Then("the total fee for is {double}")
    public void theTotalFeeForIsAmount(double fee) {
        assertEquals(fee, service.calculateFee(newBooking1), 0.1);
    }


    @Given("the following ticket types are available")
    public void theFollowingTicketTypesAreAvailable(DataTable ticketTable) {
        this.availableTickets = ticketTable.asMaps(String.class, String.class);
    }

    private BookingType findTicket(String type) {
        for (Map<String, String> ticket : availableTickets) {
            if (ticket.get("Ticket type").equals(type)) {
                return BookingType.valueOf(ticket.get("Ticket type"));
            }
        }
        throw new RuntimeException(type + " is not a valid ticket type !!");
    }

    private BookedMuseum findMuseum(String bookedMuseum) {
        for (Map<String, String> museum : availableMuseums) {
            if (museum.get("Museums").equals(bookedMuseum)) {
                BookedMuseum newBookedMuseum = BookedMuseum.valueOf(museum.get("Museums"));
                newBookedMuseum.setFee(Double.parseDouble(museum.get("Flat fee")));
                return newBookedMuseum;
            }
        }
        throw new RuntimeException(bookedMuseum + " is not a valid museum !!");
    }


    @Given("I have a Rest Spring booking {string}")
    public void iHaveARestSpringBookingEndpoint(String endpoint) {
        uriBase = endpoint;
        restClient = RestClient.create();
    }

    @When("I save a booking by calling{string}{string}{string}{string}{string}{string}")
    public void iSaveABookingByCallingNameNumberOfPersonsTicketTypeEmailMuseums
            (String name, String persons, String ticket,
             String email, String museum, String slot) {
        newBooking2 = restClient.post()
                .uri(uriBase + "/" + name+ "/" +persons+ "/" +ticket+ "/" +email+ "/" +museum+"/" +slot)
                .retrieve()
                .body(BookingDTO.class);
    }
    ///saveBooking/{name}/{numberOfPersons}/{bookingType}/{email}/{bookedMuseum}/{bookingSlot}

    @Then("I should get the{string}{string}{string}{string}{string}{string}of the customer")
    public void iShouldGetTheNameNumberOfPersonsTicketTypeEmailMuseumsOfTheCustomer(String name, String persons, String ticket,
                                                                                    String email, String museum, String slot) {

        assertAll("Test save booking",
                () -> Assertions.assertEquals(name, newBooking2.getName()),
                () -> Assertions.assertEquals(email, newBooking2.getEmail()),
                () -> Assertions.assertEquals(ticket, newBooking2.getBookingType().toString()),
                () -> Assertions.assertEquals(museum, newBooking2.getBookedMuseum().toString()),
                () -> Assertions.assertEquals(slot, newBooking2.getBookingSlot())
        );
    }


}


