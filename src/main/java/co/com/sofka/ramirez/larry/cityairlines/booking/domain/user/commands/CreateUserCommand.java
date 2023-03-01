package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Command;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Identity;

public class CreateUserCommand extends Command {

    private final Identity id;
    private final UserFacturationData facturationData;
    private final UserData data;

    public CreateUserCommand(Identity id, UserFacturationData facturationData, UserData data){
        this.id = id;
        this.facturationData = facturationData;
        this.data = data;
    }

    public Identity id() {
        return id;
    }

    public UserFacturationData facturationData() {
        return facturationData;
    }

    public UserData data() {
        return data;
    }
}
