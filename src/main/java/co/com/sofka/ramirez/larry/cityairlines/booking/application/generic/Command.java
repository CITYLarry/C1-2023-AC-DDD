package co.com.sofka.ramirez.larry.cityairlines.booking.application.generic;

import java.time.Instant;
import java.util.UUID;

public abstract class Command {

    public final Instant when;
    private final String uuid;

    public Command() {
        this.uuid = UUID.randomUUID().toString();
        this.when = Instant.now();
    }

    public Instant when() {
        return when;
    }

    public String uuid() {
        return uuid;
    }
}
