package co.com.sofka.ramirez.larry.cityairlines.booking.business.commons;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Command;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;

import java.util.List;

public interface CommandUseCase <T extends Command>{

    List<DomainEvent> apply(T command);
}
