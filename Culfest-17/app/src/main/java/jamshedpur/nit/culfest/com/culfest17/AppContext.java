package jamshedpur.nit.culfest.com.culfest17;

import com.google.firebase.database.FirebaseDatabase;




/**
 * Created by Aditya on 22-12-2016.
 */

public class AppContext extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        //Firebase.setAndroidContext(this);
    }
}
