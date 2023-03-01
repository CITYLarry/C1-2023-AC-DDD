package co.com.sofka.ramirez.larry.cityairlines.booking.business.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.CommandUseCase;
import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.User;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.AddPassengerCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.UserId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.IdNum;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.PassengerEmail;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.PassengerName;

import java.util.List;

public class AddPassengerUseCase implements CommandUseCase<AddPassengerCommand> {

    private final EventsRepository eventsRepository;

    public AddPassengerUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddPassengerCommand command) {
        List<DomainEvent> userEvents = eventsRepository.findAggregateRootId(command.getUserId());
        User user = User.from(UserId.of(command.getUserId()), userEvents);
        user.addPassenger(
                PassengerId.of(command.getPassengerId()),
                new PassengerName(command.getPassengerName()),
                new IdNum(command.getIdNum()),
                new PassengerEmail(command.getPassengerEmail())
        );
        return user.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent)
                .toList();
    }
}
