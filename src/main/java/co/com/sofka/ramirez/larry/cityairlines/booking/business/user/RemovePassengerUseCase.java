package co.com.sofka.ramirez.larry.cityairlines.booking.business.user;


import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.CommandUseCase;
import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.User;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.RemovePassengerCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.UserId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemovePassengerUseCase implements CommandUseCase<RemovePassengerCommand> {

    private final EventsRepository eventsRepository;

    public RemovePassengerUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public List<DomainEvent> apply(RemovePassengerCommand command) {
        List<DomainEvent> userEvents = eventsRepository.findAggregateRootId(command.getUserId());
        User user = User.from(UserId.of(command.getUserId()), userEvents);
        user.removePassenger(PassengerId.of(command.getPassengerId()));
        return user.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent)
                .toList();
    }
}
