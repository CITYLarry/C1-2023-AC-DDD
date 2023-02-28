package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values;

import co.com.sofka.ramirez.larry.cityairlines.booking.application.generic.ValueObject;

public class PassengerData implements ValueObject<PassengerData.Props> {

    private final String name;
    private final String idNum;
    private final String email;
    private final String telephone;

    public PassengerData(String name, String idNum, String email, String telephone) {
        this.name = name;
        this.idNum = idNum;
        this.email = email;
        this.telephone = telephone;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String name() {
                return name;
            }

            @Override
            public String idNum() {
                return idNum;
            }

            @Override
            public String email() {
                return email;
            }

            @Override
            public String telephone() {
                return telephone;
            }
        };
    }

    public interface Props {
        String name();
        String idNum();
        String email();
        String telephone();
    }
}
