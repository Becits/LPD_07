package mpi.lpd_07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
    }

    // Paariet uz pasaakuma informaacijas logu
    public void buttonApraksts(View view){
        Intent nIntent = new Intent(Events.this, EventDesc.class);
        startActivity(nIntent);
    }

    // Poga "Izveidot pasākumu"
    public void buttonPievienot(View view){
        Intent nIntent = new Intent(Events.this, NewEvent.class);
        startActivity(nIntent);
    }

}
