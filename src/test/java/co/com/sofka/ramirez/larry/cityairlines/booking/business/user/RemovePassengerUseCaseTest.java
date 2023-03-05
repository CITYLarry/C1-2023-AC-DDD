package co.com.sofka.ramirez.larry.cityairlines.booking.business.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.AddPassengerCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.CreateUserCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.RemovePassengerCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.AddedPassenger;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.RemovedPassenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RemovePassengerUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateUserUseCase createUserUseCase;
    private AddPassengerUseCase addPassengerUseCase;
    private RemovePassengerUseCase removePassengerUseCase;

    @BeforeEach
    void setUp() {
        createUserUseCase = new CreateUserUseCase(eventsRepository);
        removePassengerUseCase = new RemovePassengerUseCase(eventsRepository);
        addPassengerUseCase = new AddPassengerUseCase(eventsRepository);
    }

    @DisplayName("Remove Pasenger")
    @Test
    void removePassenger() {

        CreateUserCommand createUserCommand = new CreateUserCommand(
                "testUserId",
                "Test user",
                "testpassword",
                "test@email.com",
                "12st city country 76000"
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(CreatedUser.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> userEvents = createUserUseCase.apply(createUserCommand);

        Mockito.when(eventsRepository.findAggregateRootId(userEvents.get(0).aggregateRootId()))
                .thenReturn(userEvents);


        AddPassengerCommand addPassengerCommand = new AddPassengerCommand(
                "testPassengerId",
                "testPassengerName",
                "testPassengerEmail",
                "testIdNum",
                "testUserId"
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(AddedPassenger.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> addPassengerEvents = addPassengerUseCase.apply(addPassengerCommand);


        RemovePassengerCommand removePassengerCommand = new RemovePassengerCommand(
                "testPassengerId",
                "testUserId"
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(RemovedPassenger.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> removePassengerEvents = removePassengerUseCase.apply(removePassengerCommand);

        RemovedPassenger passenger = (RemovedPassenger) removePassengerEvents.get(0);

        Assertions.assertTrue(removePassengerEvents.get(0) instanceof RemovedPassenger);
        Assertions.assertEquals(removePassengerCommand.getPassengerId(), passenger.passengerId().value());

    }
}
