package demo2.beans;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Event {
    private final int id;
    private String msg;
    private final Date date;
    private final DateFormat df;

    public Event(Date date, DateFormat df) {
        Random rand = new Random();
        this.id = rand.nextInt(1000) + 1;
        this.date = date;
        this.df = df;
    }

    public static boolean isDay() {
        int currentHour = LocalDateTime.now().getHour();
        return (currentHour >= 8 && currentHour < 17);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return id + " " + df.format(date) + " " + msg;
    }



}
