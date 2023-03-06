package co.com.sofka.ramirez.larry.cityairlines.booking.business.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.BookFlightCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.CreateReservationCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.BookedFlight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.ArrivalAirport;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.ArrivalTime;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.DepartureAirport;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.DepartureTime;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.FlightId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookFlightUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateReservationUseCase createReservationUseCase;
    private BookFlightUseCase bookFlightUseCase;

    @BeforeEach
    void setup() {
        createReservationUseCase = new CreateReservationUseCase(eventsRepository);
        bookFlightUseCase = new BookFlightUseCase(eventsRepository);
    }

    @DisplayName("Book Flight")
    @Test
    void bookFlight() {

        CreateReservationCommand createReservationCommand = new CreateReservationCommand(
                "testReservationId",
                "testUserId"
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(CreatedReservation.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> reservationsEvents = createReservationUseCase.apply(createReservationCommand);

        Mockito.when(eventsRepository.findAggregateRootId(reservationsEvents.get(0).aggregateRootId()))
                .thenReturn(reservationsEvents);

        BookFlightCommand bookFlightCommand = new BookFlightCommand(
                "testFlightId",
                "testDepartureAirport",
                "testArrivalAirport",
                Instant.parse("2023-03-06T07:00:00Z"),
                Instant.parse("2023-03-06T14:00:00Z"),
                "testReservationId"
        );

        BookedFlight bookedFlight = new BookedFlight(
                FlightId.of("testFlightId"),
                new DepartureAirport("testDepartureAirport"),
                new ArrivalAirport("testArrivalAirport"),
                new DepartureTime(Instant.parse("2023-03-06T07:00:00Z")),
                new ArrivalTime(Instant.parse("2023-03-06T14:00:00Z"))
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(BookedFlight.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> result = bookFlightUseCase.apply(bookFlightCommand);

        Assertions.assertEquals(1, result.size());

        BookedFlight flight = (BookedFlight) result.get(0);

        Assertions.assertEquals(bookedFlight.flightId().value(), flight.flightId().value());
    }
}
