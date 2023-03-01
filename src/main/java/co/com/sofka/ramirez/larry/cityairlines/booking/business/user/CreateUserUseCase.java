package co.com.sofka.ramirez.larry.cityairlines.booking.business.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.CommandUseCase;
import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.User;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.CreateUserCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.UserId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.Address;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.Password;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.UserEmail;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.UserName;

import java.util.List;

public class CreateUserUseCase implements CommandUseCase<CreateUserCommand> {

    private final EventsRepository eventsRepository;

    public CreateUserUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateUserCommand command) {
        User user = new User(
                UserId.of(command.getUserId()),
                new UserName(command.getUserName()),
                new Password(command.getPassword()),
                new UserEmail(command.getUserEmail()),
                new Address(command.getAddress())
        );
        return user.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent)
                .toList();
    }
}
