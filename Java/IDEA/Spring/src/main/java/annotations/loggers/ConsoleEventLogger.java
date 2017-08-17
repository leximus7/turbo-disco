package annotations.loggers;

import annotations.beans.Event;
import org.springframework.stereotype.Component;

@Component
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
