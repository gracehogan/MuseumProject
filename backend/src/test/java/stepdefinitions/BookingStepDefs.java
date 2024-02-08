package stepdefinitions;

import com.barclays.dto.BookingDTO;
import com.barclays.model.Booking;
import com.barclays.model.enums.BookedMuseum;
import com.barclays.model.enums.BookingType;
import com.barclays.repository.BookingRepository;
import com.barclays.service.BookingService;
import com.barclays.service.BookingServiceImpl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class BookingStepDefs {
    private List<Map<String, String>> availableMuseums;
    private List<Map<String, String>> availableTickets;
    private List<Map<String, String>> registeredBookings;

    BookingRepository bookingRepository;
    BookingService service = new BookingServiceImpl(bookingRepository);




    BookingDTO booking;
    BookingDTO newBooking;


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
    public void nameBooksAVisitToMuseumsWithTicketTypeForPersons(String name,String museums,String ticket,String persons) {
         newBooking= findBooking(name);
        newBooking.setBookingType(findTicket(ticket));
        newBooking.setNumberOfPersons(Integer.parseInt(persons));
        newBooking.setBookedMuseum(findMuseum(museums));
    }

    @Then("the total fee for is {double}")
    public void theTotalFeeForIsAmount(double fee) {
        assertEquals(fee,service.calculateFee(newBooking),0.1);
    }

    @Given("the following ticket types are available")
    public void theFollowingTicketTypesAreAvailable(DataTable ticketTable) {
        this.availableTickets= ticketTable.asMaps(String.class, String.class);
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
                BookedMuseum  newBookedMuseum = BookedMuseum.valueOf(museum.get("Museums"));
                newBookedMuseum.setFee(Double.parseDouble(museum.get("Flat fee")));
                return newBookedMuseum;
            }
        }
        throw new RuntimeException(bookedMuseum + " is not a valid museum !!");
    }


}
