package mpi.lpd_07;

import android.hardware.camera2.params.Face;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.FacebookSdk;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_profile);
        try{
            String Vards = com.facebook.Profile.getCurrentProfile().getFirstName() + " " + com.facebook.Profile.getCurrentProfile().getLastName();
            TextView textView = (TextView) findViewById(R.id.tv_p_vards);
            textView.setText(Vards);
        }catch (Exception e){

        }

    }
}
