package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class FlightAirportData implements ValueObject<FlightAirportData.Props> {

    private final String departure;
    private final String arrival;

    public FlightAirportData(String departure, String arrival){
        this.departure = departure;
        this.arrival = arrival;
    }

    @Override
    public Props value() {
        return new Props() {

            @Override
            public String departure(){
                return departure;
            }

            @Override
            public String arrival(){
                return arrival;
            }
        };
    }
    public interface Props {
        String departure();
        String arrival();
    }
}
