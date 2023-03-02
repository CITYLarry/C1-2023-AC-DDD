package co.com.sofka.ramirez.larry.cityairlines.booking.business.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.CommandUseCase;
import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Reservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.BookFlightCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Flight;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.ArrivalAirport;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.ArrivalTime;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.DepartureAirport;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight.DepartureTime;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.FlightId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.ReservationId;

import java.util.List;

public class BookFlightUseCase implements CommandUseCase<BookFlightCommand> {

    private final EventsRepository eventsRepository;

    public BookFlightUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public List<DomainEvent> apply(BookFlightCommand command) {
        List<DomainEvent> reservationEvents = eventsRepository.findAggregateRootId(command.getReservationId());
        Reservation reservation = Reservation.from(ReservationId.of(command.getReservationId()), reservationEvents);
        reservation.bookFlight(Flight.from(
                FlightId.of(command.getFlightId()),
                new DepartureAirport(command.getDepartureAirport()),
                new ArrivalAirport(command.getArrivalAirport()),
                new DepartureTime(command.getDepartureTime()),
                new ArrivalTime(command.getArrivalTime())
        ));
        return reservation.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent)
                .toList();
    }
}
