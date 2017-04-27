package mpi.lpd_07;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Events extends AppCompatActivity {
    ConnectionClass connectionClass;
    ImageView img;
    byte[] fileBytes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        img = (ImageView) findViewById(R.id.iv_pasiko);
        connectionClass = new ConnectionClass();

        DoLogin  doLogin = new DoLogin();
        doLogin.execute("");
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

    public class DoLogin extends AsyncTask<String,String,String> {
        String z = "";
        Boolean isSuccess = false;


        @Override
        protected void onPostExecute(String r) {
            Bitmap bmp = BitmapFactory.decodeByteArray(fileBytes, 0, fileBytes.length);

            img.setImageBitmap(Bitmap.createScaledBitmap(bmp, img.getWidth(),
                    img.getHeight(), false));

            /* Toast.makeText(Events.this, r, Toast.LENGTH_SHORT).show();

            if (isSuccess) {
                Toast.makeText(Events.this, r, Toast.LENGTH_SHORT).show();
            }
            */

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Connection con = connectionClass.CONN();
                if (con == null) {
                    z = "Error in connection with SQL server";
                } else {
                    String query = "select Photo from GALLERY WHERE Id="+2;
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    if (rs.next()) {
                        z="Success!";
                        isSuccess = true;
                        fileBytes = rs.getBytes(1);
                    } else {
                        z = "Invalid Credentials";
                        isSuccess = false;
                    }

                }
            } catch (Exception ex) {
                isSuccess = false;
                z = "Exceptions";
            }
            return z;
        }

    }

}
