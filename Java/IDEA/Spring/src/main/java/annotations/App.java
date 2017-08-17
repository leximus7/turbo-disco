package annotations;

import annotations.beans.Client;
import annotations.beans.Event;
import annotations.beans.EventType;
import annotations.loggers.EventLogger;
import annotations.spring.AppConfig;
import annotations.spring.LoggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class App {

    @Autowired
    private Client client;

    @Resource(name="defaultLogger")
    private EventLogger defaultLogger;

    @Resource(name="loggerMap")
    private Map<EventType, EventLogger> loggers;

    public App(){}

    App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers){
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register (AppConfig.class, LoggerConfig.class);
        ctx.scan("annotations");
        ctx.refresh();

//        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        Client client = ctx.getBean(Client.class);
        System.out.println("Client says: " + client.getGreeting());

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
