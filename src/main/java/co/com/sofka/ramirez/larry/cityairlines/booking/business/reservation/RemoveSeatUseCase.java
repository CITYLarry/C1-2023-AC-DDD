package co.com.sofka.ramirez.larry.cityairlines.booking.business.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.CommandUseCase;
import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Reservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.RemoveSeatCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.ReservationId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemoveSeatUseCase implements CommandUseCase<RemoveSeatCommand> {

    private final EventsRepository eventsRepository;

    public RemoveSeatUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(RemoveSeatCommand command) {
        List<DomainEvent> reservationEvents = eventsRepository.findAggregateRootId(command.getReservationId());
        Reservation reservation = Reservation.from(ReservationId.of(command.getReservationId()), reservationEvents);
        reservation.removeSeat(PassengerId.of(command.getPassengerId()));
        return reservation.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent)
                .toList();
    }
}
