package co.com.sofka.ramirez.larry.cityairlines.booking.business.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.CommandUseCase;
import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Reservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.CreateReservationCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.ReservationId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.UserId;

import java.util.List;

public class CreateReservationUseCase implements CommandUseCase<CreateReservationCommand> {

    private final EventsRepository eventsRepository;

    public CreateReservationUseCase(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateReservationCommand command) {
        Reservation reservation = new Reservation(
                ReservationId.of(command.getReservationId()),
                UserId.of(command.getUserId())
        );
        return reservation.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent)
                .toList();
    }
}
