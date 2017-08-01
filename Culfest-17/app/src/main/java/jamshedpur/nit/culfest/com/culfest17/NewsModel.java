package jamshedpur.nit.culfest.com.culfest17;

/**
 * Created by Aditya on 26-12-2016.
 */

public class NewsModel {
    String title,message,time;
    NewsModel()
    {

    }
    NewsModel(String title,String message,String time)
    {
        this.title=title;
        this.message=message;
        this.time=time;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() { return time;    }
}
