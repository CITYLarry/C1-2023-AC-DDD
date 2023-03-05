package co.com.sofka.ramirez.larry.cityairlines.booking.business.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.CreateUserCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.Address;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.Password;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.UserEmail;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.user.UserName;
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
class CreateUserUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateUserUseCase createUserUseCase;

    @BeforeEach
    void setup() {
        createUserUseCase = new CreateUserUseCase(eventsRepository);
    }

    @DisplayName("User creation")
    @Test
    void successfullyScenario() {
        CreateUserCommand createUserCommand = new CreateUserCommand(
                "testId",
                "Test user",
                "testpassword",
                "test@email.com",
                "12st city country 76000");

        CreatedUser createdUser = new CreatedUser(
                new UserName("Test user"),
                new Password("testpassword"),
                new UserEmail("test@email.com"),
                new Address("12st city country 76000"));
        createdUser.setAggregateRootId("testId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(CreatedUser.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> domainEvents = createUserUseCase.apply(createUserCommand);

        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals(createdUser.aggregateRootId(), domainEvents.get(0).aggregateRootId());

        DomainEvent createdEvent = domainEvents.get(0);

        Assertions.assertTrue(createdEvent instanceof CreatedUser);

        CreatedUser createdUserEvent = (CreatedUser) createdEvent;

        Assertions.assertEquals("Test user", createdUserEvent.userName().value());
        Assertions.assertEquals("testpassword", createdUserEvent.password().value());
        Assertions.assertEquals("test@email.com", createdUserEvent.userEmail().value());
        Assertions.assertEquals("12st city country 76000", createdUserEvent.address().value());
    }
}
