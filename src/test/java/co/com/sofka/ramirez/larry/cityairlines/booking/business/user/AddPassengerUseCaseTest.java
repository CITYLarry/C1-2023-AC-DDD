package co.com.sofka.ramirez.larry.cityairlines.booking.business.user;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands.AddPassengerCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.AddedPassenger;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.events.CreatedUser;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.PassengerId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.IdNum;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.PassengerEmail;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.passenger.PassengerName;
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
public class AddPassengerUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddPassengerUseCase addPassengerUseCase;

    @BeforeEach
    void setUp() {
        addPassengerUseCase = new AddPassengerUseCase(eventsRepository);
    }

    @DisplayName("Add Passenger")
    @Test
    void addPassenger(){

        CreatedUser createdUser = new CreatedUser(
                new UserName("testUserName"),
                new Password("testPassword"),
                new UserEmail("testUserEmail"),
                new Address("testAddress")
        );
        createdUser.setAggregateRootId("testUserId");

        List<DomainEvent> userEvents = List.of(createdUser);

        Mockito.when(eventsRepository.findAggregateRootId(createdUser.aggregateRootId()))
                .thenReturn(userEvents);

        AddPassengerCommand addPassengerCommand = new AddPassengerCommand(
                "testPassengerId",
                "testPassengerName",
                "testPassengerEmail",
                "testIdNum",
                "testUserId"
        );

        AddedPassenger addedPassenger = new AddedPassenger(
                PassengerId.of("testPassengerId"),
                new PassengerName("testPassengerName"),
                new PassengerEmail("testPassengerEmail"),
                new IdNum("testIdNum")
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(AddedPassenger.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> result = addPassengerUseCase.apply(addPassengerCommand);

        Assertions.assertEquals(1, result.size());

        AddedPassenger passenger = (AddedPassenger) result.get(0);

        Assertions.assertEquals(addedPassenger.passengerId().value(), passenger.passengerId().value());
        Assertions.assertEquals(addedPassenger.passengerName().value(), passenger.passengerName().value());
        Assertions.assertEquals(addedPassenger.passengerEmail().value(), passenger.passengerEmail().value());
        Assertions.assertEquals(addedPassenger.idNum().value(), passenger.idNum().value());
    }
}
