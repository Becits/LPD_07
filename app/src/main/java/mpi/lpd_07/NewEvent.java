package mpi.lpd_07;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.Date;
import java.util.Locale;

public class NewEvent extends AppCompatActivity {
    private int year, month, day;
    EditText dataView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        dataView = (EditText) findViewById(R.id.et_datums);
        dataView.setOnClickListener(etDatumsCL);
    }


    View.OnClickListener etDatumsCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showDialog(999);
        }
    };
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, 2018, month, day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            //arg1 = year;
            //arg2 = month;
            //arg3 = day;
            showDate(arg1, arg2+1, arg3);
        }
    };
    private void showDate(int year, int month, int day) {
        dataView.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }
}
