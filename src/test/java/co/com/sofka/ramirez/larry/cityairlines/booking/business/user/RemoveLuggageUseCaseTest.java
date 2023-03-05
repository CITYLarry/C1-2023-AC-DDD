package co.com.sofka.ramirez.larry.cityairlines.booking.business.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.AddLuggageCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.CreateUserCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.RemoveLuggageCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities.Luggage;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.AddedLuggage;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.RemovedLuggage;
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
public class RemoveLuggageUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateUserUseCase createUserUseCase;
    private AddLuggageUseCase addLuggageUseCase;
    private RemoveLuggageUseCase removeLuggageUseCase;

    @BeforeEach
    void setUp() {
        createUserUseCase = new CreateUserUseCase(eventsRepository);
        addLuggageUseCase = new AddLuggageUseCase(eventsRepository);
        removeLuggageUseCase = new RemoveLuggageUseCase(eventsRepository);
    }

    @DisplayName("Remove Luggage")
    @Test
    void removeLuggage() {

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

        AddLuggageCommand addLuggageCommand = new AddLuggageCommand(
                "testLuggageId",
                Luggage.LuggageType.CABIN,
                "testPassengerId",
                "testUserId"
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(AddedLuggage.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> result = addLuggageUseCase.apply(addLuggageCommand);

        RemoveLuggageCommand removeLuggageCommand = new RemoveLuggageCommand(
                "testPassengerId",
                "testUserId"
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(RemovedLuggage.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> removeLuggageEvents = removeLuggageUseCase.apply(removeLuggageCommand);

        RemovedLuggage luggage = (RemovedLuggage) removeLuggageEvents.get(0);

        Assertions.assertTrue(removeLuggageEvents.get(0) instanceof RemovedLuggage);
        Assertions.assertEquals(removeLuggageCommand.getPassengerId(), luggage.passengerId().value());
    }
}
