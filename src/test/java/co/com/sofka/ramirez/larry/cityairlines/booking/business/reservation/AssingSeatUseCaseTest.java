package co.com.sofka.ramirez.larry.cityairlines.booking.business.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.AssignSeatCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.CreateReservationCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Seat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.AssignedSeat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.SeatId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat.ClassType;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat.Price;
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
public class AssingSeatUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateReservationUseCase createReservationUseCase;
    private AssignSeatUseCase assignSeatUseCase;

    @BeforeEach
    void setup() {
        createReservationUseCase = new CreateReservationUseCase(eventsRepository);
        assignSeatUseCase = new AssignSeatUseCase(eventsRepository);
    }

    @DisplayName("Assing Seat")
    @Test
    void assignSeat(){

        CreateReservationCommand createReservationCommand = new CreateReservationCommand(
                "testReservationId",
                "testUserId"
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(CreatedReservation.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> reservationsEvents = createReservationUseCase.apply(createReservationCommand);

        Mockito.when(eventsRepository.findAggregateRootId(reservationsEvents.get(0).aggregateRootId()))
                .thenReturn(reservationsEvents);

        AssignSeatCommand assignSeatCommand = new AssignSeatCommand(
                "testSeatId",
                ClassType.SeatClass.ECONOMY,
                100,
                "testPassengerId",
                "testReservationId"
        );

        AssignedSeat assignedSeat = new AssignedSeat(
                PassengerId.of("testPassengerId"),
                Seat.from(
                        SeatId.of("testSeatId"),
                        new ClassType(ClassType.SeatClass.ECONOMY),
                        new Price(100)
                )
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(AssignedSeat.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> result = assignSeatUseCase.apply(assignSeatCommand);

        Assertions.assertEquals(1, result.size());

        AssignedSeat seat = (AssignedSeat) result.get(0);

        Assertions.assertEquals(assignedSeat.passengerId().value(), seat.passengerId().value());
    }
}
