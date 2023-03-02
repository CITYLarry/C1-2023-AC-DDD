package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values.flight;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class ArrivalAirport implements ValueObject<String> {

    private final String arrivalAirport;

    public ArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @Override
    public String value() {
        return arrivalAirport;
    }
}
