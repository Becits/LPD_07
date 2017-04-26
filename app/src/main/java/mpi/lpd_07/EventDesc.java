package mpi.lpd_07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EventDesc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_desc);
    }

    // Poga "Galerija"
    public void buttonGalerija(View view){
        Intent nIntent = new Intent(EventDesc.this, Gallery.class);
        startActivity(nIntent);
    }

}
