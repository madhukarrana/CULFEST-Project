package jamshedpur.nit.culfest.com.culfest17;

/**
 * Created by Lenovo on 1/3/2017.
 */

public class EventsDataModel {
    String event_name;
    int event_image;

    public EventsDataModel(String name, int image) {
        this.event_name = name;
        this.event_image = image;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public int getEvent_image() {
        return event_image;
    }

    public void setEvent_image(int event_image) {
        this.event_image = event_image;
    }
}
