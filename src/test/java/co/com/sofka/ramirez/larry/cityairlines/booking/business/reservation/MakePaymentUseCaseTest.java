package co.com.sofka.ramirez.larry.cityairlines.booking.business.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.CreateReservationCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.MakePaymentCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.CreatedReservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.events.MadePayment;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.PaymentId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.payment.PaymentDate;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.payment.PaymentMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MakePaymentUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateReservationUseCase createReservationUseCase;
    private MakePaymentUseCase makePaymentUseCase;

    @BeforeEach
    void setup() {
        createReservationUseCase = new CreateReservationUseCase(eventsRepository);
        makePaymentUseCase = new MakePaymentUseCase(eventsRepository);
    }

    @DisplayName("Make Payment")
    @Test
    void makePayment(){

        CreateReservationCommand createReservationCommand = new CreateReservationCommand(
                "testReservationId",
                "testUserId"
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(CreatedReservation.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> reservationsEvents = createReservationUseCase.apply(createReservationCommand);

        Mockito.when(eventsRepository.findAggregateRootId(reservationsEvents.get(0).aggregateRootId()))
                .thenReturn(reservationsEvents);

        MakePaymentCommand makePaymentCommand = new MakePaymentCommand(
                "testPaymentId",
                "testPaymentMethod",
                Instant.parse("2023-03-06T07:00:00Z"),
                "testReservationId"
        );

        MadePayment madePayment = new MadePayment(
                PaymentId.of("testPaymentId"),
                new PaymentMethod("testPaymentMethod"),
                new PaymentDate(Instant.parse("2023-03-06T07:00:00Z"))
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(MadePayment.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> result = makePaymentUseCase.apply(makePaymentCommand);

        Assertions.assertEquals(1, result.size());

        MadePayment payment = (MadePayment) result.get(0);

        Assertions.assertEquals(madePayment.paymentId().value(), payment.paymentId().value());
    }
}
