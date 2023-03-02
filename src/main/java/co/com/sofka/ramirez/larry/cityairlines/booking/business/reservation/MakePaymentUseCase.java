package co.com.sofka.ramirez.larry.cityairlines.booking.business.reservation;

import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.CommandUseCase;
import co.com.sofka.ramirez.larry.cityairlines.booking.business.commons.EventsRepository;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.Reservation;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.commands.MakePaymentCommand;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.entities.Payment;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.PaymentId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.identities.ReservationId;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.payment.PaymentDate;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.payment.PaymentMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MakePaymentUseCase implements CommandUseCase<MakePaymentCommand> {

    private final EventsRepository eventsRepository;

    public MakePaymentUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public List<DomainEvent> apply(MakePaymentCommand command) {
        List<DomainEvent> reservationEvents = eventsRepository.findAggregateRootId(command.getReservationId());
        Reservation reservation = Reservation.from(ReservationId.of(command.getReservationId()), reservationEvents);
        reservation.makePayment(Payment.from(
                PaymentId.of(command.getPaymentId()),
                new PaymentDate(command.getPaymentDate()),
                new PaymentMethod(command.getPaymentMethod())
        ));
        return reservation.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent)
                .toList();
    }
}
