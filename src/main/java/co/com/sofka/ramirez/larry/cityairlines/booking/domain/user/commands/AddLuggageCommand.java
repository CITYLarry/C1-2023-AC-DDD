package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Command;
import co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.entities.Luggage;

public class AddLuggageCommand extends Command {

    private String luggageId;
    private Luggage.LuggageType type;
    private String passengerId;
    private String userId;

    public AddLuggageCommand() {}

    public AddLuggageCommand(String luggageId, Luggage.LuggageType type, String passengerId, String userId) {
        this.luggageId = luggageId;
        this.type = type;
        this.passengerId = passengerId;
        this.userId = userId;
    }

    public String getLuggageId() {
        return luggageId;
    }

    public void setLuggageId(String luggageId) {
        this.luggageId = luggageId;
    }

    public Luggage.LuggageType getType() {
        return type;
    }

    public void setType(Luggage.LuggageType type) {
        this.type = type;
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
