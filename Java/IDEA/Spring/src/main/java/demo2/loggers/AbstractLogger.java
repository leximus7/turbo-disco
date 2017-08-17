package demo2.loggers;

import demo2.beans.Event;

public abstract class AbstractLogger implements EventLogger {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


}
