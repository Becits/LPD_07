package mpi.lpd_07;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.camera2.params.Face;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_profile);

        try{
            String Vards = com.facebook.Profile.getCurrentProfile().getName();
            TextView VardsUz = (TextView) findViewById(R.id.tv_p_vards);
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            Picasso.with(this).load(com.facebook.Profile.getCurrentProfile().getProfilePictureUri(100, 120)).into(imageView);
            VardsUz.setText(Vards);

        }catch (Exception e){
        }

    }

    // Paariet uz pasaakuma informaacijas logu
    public void buttonApraksts(View view){
        Intent nIntent = new Intent(Profile.this, EventDesc.class);
        startActivity(nIntent);
    }

}
