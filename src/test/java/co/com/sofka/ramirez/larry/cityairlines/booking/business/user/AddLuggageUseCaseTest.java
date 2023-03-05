package co.com.sofka.ramirez.larry.cityairlines.booking.business.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.AddLuggageCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.CreateUserCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities.Luggage;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.AddedLuggage;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.LuggageId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
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
public class AddLuggageUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateUserUseCase createUserUseCase;
    private AddLuggageUseCase addLuggageUseCase;

    @BeforeEach
    void setUp() {
        createUserUseCase = new CreateUserUseCase(eventsRepository);
        addLuggageUseCase = new AddLuggageUseCase(eventsRepository);
    }

    @DisplayName("Add Luggage")
    @Test
    void addLuggage(){

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

        AddedLuggage addedLuggage = new AddedLuggage(
                LuggageId.of("testLuggageId"),
                Luggage.LuggageType.CABIN,
                PassengerId.of("testPassengerId")
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(AddedLuggage.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> result = addLuggageUseCase.apply(addLuggageCommand);

        Assertions.assertEquals(1, result.size());

        AddedLuggage luggage = (AddedLuggage) result.get(0);

        Assertions.assertEquals(addedLuggage.passengerId().value(), luggage.passengerId().value());
        Assertions.assertEquals(addedLuggage.passengerId().value(), luggage.passengerId().value());
        Assertions.assertEquals(addedLuggage.type(), luggage.type());
    }
}
