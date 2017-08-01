package jamshedpur.nit.culfest.com.culfest17;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class TeamActivity extends AppCompatActivity {

    TextView name, post, contact_no, email;
    ImageView button_call, button_email, image_logo;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        name = (TextView) findViewById(R.id.name);
        post = (TextView) findViewById(R.id.post);
        contact_no = (TextView) findViewById(R.id.contact_no);
        email = (TextView) findViewById(R.id.email);
        button_call = (ImageView) findViewById(R.id.button_call);
        button_email = (ImageView) findViewById(R.id.button_email);
        image_logo = (ImageView) findViewById(R.id.culfest_logo);
        int i = getIntent().getIntExtra("Position", 0);
        toolbar = (Toolbar) findViewById(R.id.team_bar);
        toolbar.setTitle("Team Culfest");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        name.setText(TeamData.name[i]);
        post.setText(TeamData.post[i]);
        contact_no.setText(TeamData.contact_no[i]);
        email.setText(TeamData.email[i]);

        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "+91" + contact_no.getText().toString().trim();
                try {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.e("CALL_INTENT", "CALL FAILED", e);
                }
            }
        });

        button_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] address = new String[1];
                address[0] = email.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, address);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Query about Culfest '17");
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
        image_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpTo(this, new Intent(this, Team.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
