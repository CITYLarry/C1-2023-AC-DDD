package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.values;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.ValueObject;

public class UserData implements ValueObject<UserData.Props> {

    private final String name;
    private final String email;
    private final String password;

    public UserData(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String name() {
                return name;
            }

            @Override
            public String email() {
                return email;
            }

            @Override
            public String password() {
                return password;
            }
        };
    }
    
    public interface Props {
        String name();
        String email();
        String password();
    }
}
