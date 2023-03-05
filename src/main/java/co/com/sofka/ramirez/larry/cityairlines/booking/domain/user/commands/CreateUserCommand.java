package co.com.sofka.ramirez.larry.cityairlines.booking.domain.user.commands;

import co.com.sofka.ramirez.larry.cityairlines.booking.domain.generic.Command;

public class CreateUserCommand extends Command {

    private String userId;
    private String userName;
    private String password;
    private String userEmail;
    private String address;


    private CreateUserCommand(){}

    public CreateUserCommand(String userId, String userName, String password, String userEmail, String address) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
