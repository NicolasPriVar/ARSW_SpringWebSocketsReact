package WebSockets.components;

import WebSockets.endpoints.TimerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
@Scope("singleton")
public class TimerMessageBroker {

    private static final SimpleDateFormat dateFormat = new
            SimpleDateFormat("HH:mm:ss");
    private static final Logger logger =
            Logger.getLogger(TimerMessageBroker.class.getName());
    @Scheduled(fixedRate = 5000)
    public void broadcast() {
        logger.log(Level.INFO, "broadcastingMessages");
        TimerEndpoint.send("The time is now " + dateFormat.format(new Date()));
    }
}