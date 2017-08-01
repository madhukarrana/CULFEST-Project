package jamshedpur.nit.culfest.com.culfest17;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoordinatorFragment extends Fragment implements View.OnClickListener {

    TextView contact_name1,contact_name2,contact_name3,phone_num1,phone_num2,phone_num3;
    ImageView contact_no1,contact_no2,contact_no3;
    LinearLayout one,two,three;
    String number;
  //  String c1, c2;

    public CoordinatorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_coordinator, container, false);

        one = (LinearLayout) rootview.findViewById(R.id.one);
        contact_name1 = (TextView) rootview.findViewById(R.id.contact_name1);
        phone_num1 = (TextView) rootview.findViewById(R.id.phone_num1);
        contact_no1 = (ImageView) rootview.findViewById(R.id.contact_no1);

        two = (LinearLayout) rootview.findViewById(R.id.two);
        contact_name2 = (TextView) rootview.findViewById(R.id.contact_name2);
        phone_num2 = (TextView) rootview.findViewById(R.id.phone_num2);
        contact_no2 = (ImageView) rootview.findViewById(R.id.contact_no2);

        three = (LinearLayout) rootview.findViewById(R.id.three);
        contact_name3 = (TextView) rootview.findViewById(R.id.contact_name3);
        phone_num3 = (TextView) rootview.findViewById(R.id.phone_num3);
        contact_no3 = (ImageView) rootview.findViewById(R.id.contact_no3);


        two.setVisibility(View.GONE);
        three.setVisibility(View.GONE);

        //contact_no1.setPaintFlags(contact_no1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        //contact_no2.setPaintFlags(contact_no2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // use switch case
        /*
          String c = ChildEvent.actionBarTitle
          switch(c) {
             case "DISTORTION":
                .setText ......


          */


        //t.setText(ChildEvent.actionBarTitle);
        switch (ChildEvent.actionBarTitle) {
            case "RADIANCE":
                contact_name1.setText("ROSHAN");
                phone_num1.setText("+91-9869984074");
                break;
            case "CHOREO NIGHT":
                contact_name1.setText("VISHWAJEET NAIK");
                phone_num1.setText("+91-9471105618");
                break;
            case "HALLA BOL":
                contact_name1.setText("SWARNADEEP HAZRA");
                phone_num1.setText("+91-9430147269");
                break;
            case "JOURNALISM":
                two.setVisibility(View.VISIBLE);
                contact_name1.setText("RAHUL TIWARY");
                phone_num1.setText("+91-8092776033");
                contact_name2.setText("UJJAYANTA BHAUMIK");
                phone_num2.setText("+91-9862764941");
                break;
            case "THEME QUIZ":
                contact_name1.setText("PRASANNA GORAI");
                phone_num1.setText("+91-9431525143");
                break;
            case "POSHAK":
                contact_name1.setText("TANMESH SINGHAL");
                phone_num1.setText("+91-8102629668");
                break;
            case "DISTORTION":
                two.setVisibility(View.VISIBLE);
                contact_name1.setText("ROHIT KUMAR");
                phone_num1.setText("+91-8603672296");
                contact_name2.setText("AAMIR");
                phone_num2.setText("+91-8651774759");

                break;
            case "FOOT LOOSE":
                contact_name1.setText("SHALINI SINGH");
                phone_num1.setText("+91-7070450046");
                break;
            case "DANCE DUO":
                contact_name1.setText("GEETHA RASHMI");
                phone_num1.setText("+91-8092473899");
                break;
            case "SHAKE ON BEAT":
                contact_name1.setText("NAMEERA NAZZ");
                phone_num1.setText("+91-9430166744");
                break;
            case "MONO ACTING":
                contact_name1.setText("SHILPA");
                phone_num1.setText("+91-8603807439");
                break;
            case "MERI MAGGI":
                contact_name1.setText("AKSHITA");
                phone_num1.setText("+91-7070450644");
                break;
            case "RANGMANCH":
                contact_name1.setText("MOHIT");
                phone_num1.setText("+91-7209583236");
                break;
            case "MIME":
                contact_name1.setText("ANMOL");
                phone_num1.setText("+91-7546841712");
                break;
            case "INDIA QUIZ":
                contact_name1.setText("RAVI SHANKAR KUMAR");
                phone_num1.setText("+91-9031649537");
                break;
            case "ENTERTAINMENT QUIZ":
                contact_name1.setText("SOURABH KUMAR");
                phone_num1.setText("+91-9693944942");
                break;
            case "JAM":
                contact_name1.setText("RICHA OJHA");
                phone_num1.setText("+91-7209959772");
                break;
            case "POTPOURRI":
                two.setVisibility(View.VISIBLE);
                contact_name1.setText("SOURABH KUMAR");
                phone_num1.setText("+91-9693944942");
                contact_name2.setText("RAVI SHANKAR");
                phone_num2.setText("+91-9031649537");
                break;
            case "DEBATE":
                contact_name1.setText("PRANAV MESHRAM");
                phone_num1.setText("+91-9471582418");
                break;
            case "WIT-A-STORY":
                contact_name1.setText("KORNALA ARUN");
                phone_num1.setText("+91-8092747694");
                break;
            case "POETRY SLAM":
                contact_name1.setText("NEETIKA SHARMA");
                phone_num1.setText("+91-9006991018");
                break;
            case "CREATIVE WRITING":
                contact_name1.setText("SWAPNIL SINGH");
                phone_num1.setText("+91-7054391667");
                break;
            case "SSMQ":
                contact_name1.setText("ANKUR");
                phone_num1.setText("+91-8406028040");
                break;
            case "EASTERN VOCALS":
                contact_name1.setText("NEELAM TOPNO");
                phone_num1.setText("+91-8083969915");

                break;
            case "WESTERN VOCALS":
                contact_name1.setText("CHETAN");
                phone_num1.setText("+91-9430363326");
                break;
            case "DUET VOCALS":
                contact_name1.setText("ANKET GHOSH");
                phone_num1.setText("+91-7856858527");
                break;
            case "GROUP SONG":
                contact_name1.setText("NEELAM SHARMA");
                phone_num1.setText("+91-8092471293");
                break;
            case "RANGOLI":
                contact_name1.setText("BIVEK KUMAR");
                phone_num1.setText("+91-7209392723");
                break;
            case "FACE PAINTING":
                contact_name1.setText("SUMRAT MEENA");
                phone_num1.setText("+91-7050579257");
                break;
            case "T-SHIRT PAINTING":
                contact_name1.setText("NIPSA");
                phone_num1.setText("+91-8092757463");
                break;
            case "CLAY DOH":
                contact_name1.setText("KARTIK KANOJIA");
                phone_num1.setText("+91-7070450621");
                break;
            case "TRIATHLON":
                contact_name1.setText("AVANTIKA BHARTI");
                phone_num1.setText("+91-8579064858");
                break;
            case "SOAP CARVING":
                contact_name1.setText("SWARNADEEP HAZRA");
                phone_num1.setText("+91-9430147269");
                break;
            case "FUTSAL":
                two.setVisibility(View.VISIBLE);
                contact_name1.setText("MOHIT");
                phone_num1.setText("+91-7209583236");
                contact_name2.setText("SHAHNAWAAZ");
                phone_num2.setText("+91-7541829058");
                break;
            case "TECHNO CRICKET":
                two.setVisibility(View.VISIBLE);
                contact_name1.setText("JAYANT");
                phone_num1.setText("+91-7549088075");
                contact_name2.setText("SHAHNAWAAZ");
                phone_num2.setText("+91-9006806152");
                break;
            case "FACE-OFF":
                two.setVisibility(View.VISIBLE);
                contact_name1.setText("SNEH SPARSH");
                phone_num1.setText("+91-9525072067");
                contact_name2.setText("ARUN KR. MISHRA");
                phone_num2.setText("+91-8581827829");
                break;
            case "RJ HUNT":
                contact_name1.setText("SUSHEEL KRISHNA");
                phone_num1.setText("+91-9470918826");
                break;
            case "TREASURE HUNT":
                contact_name1.setText("SAMPATH");
                phone_num1.setText("+91-9471105667");
                break;
            case "ANTAKSHRI":
                contact_name1.setText("KSS SUNDEEP");
                phone_num1.setText("+91-8142127781");
                break;
            case "UNPLUGGED":
                contact_name1.setText("RAJIV KUMAR");
                phone_num1.setText("+91-9570040029");

                break;
            case "COS PLAY":
                two.setVisibility(View.VISIBLE);
                contact_name1.setText("KSS SUNDEEP");
                phone_num1.setText("+91-8142127781");
                contact_name2.setText("SURAJ");
                phone_num2.setText("+91-8292333432");
                break;
            case "BLIND DATE":
                contact_name1.setText("AMBIKESH ATUL");
                phone_num1.setText("+91-8409418859");
                break;
            case "PAPER DANCE":
                contact_name1.setText("Will be updated soon..");
                phone_num1.setVisibility(View.GONE);
                contact_no1.setVisibility(View.GONE);
                break;
        }

            contact_no1.setOnClickListener(this);
            contact_no2.setOnClickListener(this);
            contact_no3.setOnClickListener(this);

            return rootview;
        }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.contact_no1) {
            number = phone_num1.getText().toString().trim();
            if(number.length() > 2)
                callPhoneIntent(number);
        }
        else if(id == R.id.contact_no2) {
            number = phone_num2.getText().toString().trim();
            if(number.length() > 2)
                callPhoneIntent(number);
        }
        else if(id == R.id.contact_no3)
        {
            number = phone_num3.getText().toString().trim();
            if(number.length() > 2)
                callPhoneIntent(number);
        }
    }

    public void callPhoneIntent(String number) {
        number = number.trim();
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e("CALL_INTENT", "CALL FAILED", e);
        }
    }
}
