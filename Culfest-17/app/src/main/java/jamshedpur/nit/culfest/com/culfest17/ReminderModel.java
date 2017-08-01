package jamshedpur.nit.culfest.com.culfest17;

/**
 * Created by Aditya on 12-01-2017.
 */

public class ReminderModel {
    String event;
    String from;
    String to;

    public ReminderModel(String event, String from, String to) {
        this.event = event;
        this.from = from;
        this.to=to;
    }

    public ReminderModel()
    {

    }


    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}
