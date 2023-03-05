package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Command;

public class RemoveLuggageCommand extends Command {

    private String passengerId;
    private String userId;

    private RemoveLuggageCommand(){}

    public RemoveLuggageCommand(String passengerId, String userId) {
        this.passengerId = passengerId;
        this.userId = userId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
