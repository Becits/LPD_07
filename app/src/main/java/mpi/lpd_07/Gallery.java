package mpi.lpd_07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Gallery extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toast toast = new Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_SHORT);
        toast.show();
    }
}
