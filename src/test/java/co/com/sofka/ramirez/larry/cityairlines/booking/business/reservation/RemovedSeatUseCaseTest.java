package co.com.sofka.ramirez.larry.cityairlines.booking.business.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.AssignSeatCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.CreateReservationCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.RemoveSeatCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.AssignedSeat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.RemovedSeat;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.seat.ClassType;
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
public class RemovedSeatUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateReservationUseCase createReservationUseCase;
    private AssignSeatUseCase assignSeatUseCase;
    private RemoveSeatUseCase removeSeatUseCase;

    @BeforeEach
    void setup() {
        createReservationUseCase = new CreateReservationUseCase(eventsRepository);
        assignSeatUseCase = new AssignSeatUseCase(eventsRepository);
        removeSeatUseCase = new RemoveSeatUseCase(eventsRepository);
    }

    @DisplayName("Remove Seat")
    @Test
    void removeSeat() {
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

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(AssignedSeat.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> assignSeatEvents = assignSeatUseCase.apply(assignSeatCommand);

        RemoveSeatCommand removeSeatCommand = new RemoveSeatCommand(
                "testPassengerId",
                "testReservationId"
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(RemovedSeat.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> removeSeatEvents = removeSeatUseCase.apply(removeSeatCommand);

        RemovedSeat seat = (RemovedSeat) removeSeatEvents.get(0);

        Assertions.assertTrue(removeSeatEvents.get(0) instanceof RemovedSeat);
        Assertions.assertEquals(removeSeatCommand.getPassengerId(), seat.passengerId().value());
    }
}
