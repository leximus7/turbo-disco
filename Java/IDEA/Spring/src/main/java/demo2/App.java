package demo2;

import demo2.beans.Client;
import demo2.beans.Event;
import demo2.beans.EventType;
import demo2.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


public class App {
    private Client client;

    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    private String startupMessage;

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers){
        super();
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public void setDefaultLogger(EventLogger defaultLogger) {
        this.defaultLogger = defaultLogger;
    }

    public void setStartupMessage(String startupMessage) {
        this.startupMessage = startupMessage;
    }

    public EventLogger getDefaultLogger() {
        return defaultLogger;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        System.out.println(app.startupMessage);

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for user 1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for user 2");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for user 3");

        ctx.close();

    }

    private void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }

        logger.logEvent(event);
    }
}
