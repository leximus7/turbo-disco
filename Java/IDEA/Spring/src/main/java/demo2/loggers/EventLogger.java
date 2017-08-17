package demo2.loggers;

import demo2.beans.Event;

import java.io.IOException;

public interface EventLogger {

    public void logEvent(Event event);

    public String getName();

}
