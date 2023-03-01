package co.com.sofka.ramirez.larry.cityairlines.booking.domain.reservation.values;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

import java.sql.Timestamp;

public class FlightTimeData implements ValueObject<FlightTimeData.Props> {

    private final Timestamp departure;
    private final Timestamp arrival;

    public FlightTimeData(Timestamp departure, Timestamp arrival){
        this.departure = departure;
        this.arrival = arrival;
    }

    @Override
    public Props value() {
        return new Props() {

            @Override
            public Timestamp departure(){
                return departure;
            }

            @Override
            public Timestamp arrival(){
                return arrival;
            }
        };
    }

    public interface Props {
        Timestamp departure();
        Timestamp arrival();
    }
}
