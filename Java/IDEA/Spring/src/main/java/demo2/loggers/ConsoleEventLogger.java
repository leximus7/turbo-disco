package demo2.loggers;

import demo2.beans.Event;

public class ConsoleEventLogger extends AbstractLogger {

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
