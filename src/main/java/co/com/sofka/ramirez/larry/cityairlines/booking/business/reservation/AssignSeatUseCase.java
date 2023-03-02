package co.com.sofka.ramirez.larry.cityairlines.booking.business.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.CommandUseCase;
import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Reservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.AssignSeatCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Seat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.ReservationId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.SeatId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat.ClassType;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat.Price;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssignSeatUseCase implements CommandUseCase<AssignSeatCommand> {

    private final EventsRepository eventsRepository;

    public AssignSeatUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AssignSeatCommand command) {
        List<DomainEvent> reservationEvents = eventsRepository.findAggregateRootId(command.getReservationId());
        Reservation reservation = Reservation.from(ReservationId.of(command.getReservationId()), reservationEvents);
        reservation.assignSeat(
                PassengerId.of(command.getPassengerId()),
                Seat.from(SeatId.of(command.getSeatId()),
                        new ClassType(command.getClassType()),
                        new Price(command.getPrice()))
        );
        return reservation.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent)
                .toList();
    }
}
