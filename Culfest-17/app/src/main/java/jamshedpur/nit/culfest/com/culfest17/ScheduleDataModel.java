package jamshedpur.nit.culfest.com.culfest17;


public class ScheduleDataModel {


    String event;
    String venue;
    String time;

    public ScheduleDataModel(String event, String venue, String time) {
        this.event = event;
        this.venue = venue;
        this.time = time;
    }
    public ScheduleDataModel()
    {

    }

    public String getVenue() {
        return venue;
    }

    public String getEvent() {
        return event;
    }

    public String getTime() {
        return time;
    }
}