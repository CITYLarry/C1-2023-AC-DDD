package co.com.sofka.ramirez.larry.cityairlines.booking.business.commons;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.DomainEvent;

import java.util.List;

public interface EventsRepository {

    DomainEvent saveEvent(DomainEvent event);

    List<DomainEvent> findAggregateRootId(String aggregateRootId);
}
