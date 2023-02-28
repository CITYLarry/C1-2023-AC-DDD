package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class UserFacturationData implements ValueObject<UserFacturationData.Props> {

    private final String street;
    private final String city;
    private final String country;
    private final String zipCode;

    public UserFacturationData(String street, String city, String country, String zipCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String street() {
                return street;
            }

            @Override
            public String city() {
                return city;
            }

            @Override
            public String country() {
                return country;
            }

            @Override
            public String zipCode() {
                return zipCode;
            }
        };
    }

    public interface Props {
        String street();
        String city();
        String country();
        String zipCode();
    }
}
