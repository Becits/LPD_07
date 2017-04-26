package mpi.lpd_07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    // Poga "Izveidot pasaakumu"
    public void buttonIzveidot(View view){
        Intent nIntent = new Intent(MainMenu.this, NewEvent.class);
        startActivity(nIntent);
    }

    // Poga "Pasaakumi"
    public void buttonPasakumi(View view){
        Intent nIntent = new Intent(MainMenu.this, Events.class);
        startActivity(nIntent);
    }

    // Poga "Draugi"
    public void buttonDraugi(View view){
        Intent nIntent = new Intent(MainMenu.this, Friends.class);
        startActivity(nIntent);
    }

    // Poga "Profils"
    public void buttonProfils(View view){
        Intent nIntent = new Intent(MainMenu.this, Profile.class);
        startActivity(nIntent);
    }

    // Poga "Iziet"
    public void buttonIziet(View view){
        Intent nIntent = new Intent(MainMenu.this, LoginActivity.class);
        nIntent.putExtra("FBlogout", true);
        startActivity(nIntent);

    }

}
