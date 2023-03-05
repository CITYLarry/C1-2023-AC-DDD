package co.com.sofka.ramirez.larry.cityairlines.booking.business.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.CreateReservationCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values.identities.UserId;
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
public class CreateReservationUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;

    private CreateReservationUseCase createReservationUseCase;

    @BeforeEach
    void setUp() {
        createReservationUseCase = new CreateReservationUseCase(eventsRepository);
    }

    @DisplayName("Reservation creation")
    @Test
    void successfullyScenario(){
        CreateReservationCommand createReservationCommand = new CreateReservationCommand(
                "testReservationId",
                "testUserId"
        );

        CreatedReservation createdReservation= new CreatedReservation(UserId.of("testUserId"));
        createdReservation.setAggregateRootId("testReservationId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(CreatedReservation.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> domainEvents = createReservationUseCase.apply(createReservationCommand);

        Assertions.assertEquals(1, domainEvents.size());
        Assertions.assertEquals(createdReservation.aggregateRootId(), domainEvents.get(0).aggregateRootId());
    }
}
