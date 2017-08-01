package jamshedpur.nit.culfest.com.culfest17;

/**
 * Created by Aditya on 16-12-2016.
 */

public class TeamDataModel {

    String name;
    String post;
    String contact_no;
    String email;

    public TeamDataModel(String name, String post, String contact_no, String email ) {
        this.name = name;
        this.post = post;
        this.contact_no = contact_no;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public String getPost() { return post; }

    public String getContact_no() {
        return contact_no;
    }

    public String getEmail() {
        return email;
    }

}
