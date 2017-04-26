package mpi.lpd_07;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.Date;
import java.util.Locale;

import static android.R.attr.checked;

public class NewEvent extends AppCompatActivity {
    private int year, month, day, mHour, mMinute;
    EditText dataView;
    EditText timeView;
    Switch swDraugi;
    Button btnDraugi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        dataView = (EditText) findViewById(R.id.et_datums);
        dataView.setOnClickListener(etDatumsCL);
        timeView = (EditText) findViewById(R.id.et_laiks);
        timeView.setOnClickListener(etTimeCL);
        swDraugi = (Switch) findViewById(R.id.switch_privats);
        swDraugi.setOnClickListener(swDraugiCL);
        btnDraugi = (Button) findViewById(R.id.btn_draugiVeidot);
        btnDraugi.setOnClickListener(btnDraugiCL);
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
    View.OnClickListener etTimeCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(NewEvent.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    timeView.setText(hourOfDay + ":" + minute);
                }
            }, mHour, mMinute, true );
            timePickerDialog.show();
        }
    };
    View.OnClickListener swDraugiCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(swDraugi.isChecked()){
                btnDraugi.setVisibility(View.VISIBLE);
            } else {
                btnDraugi.setVisibility(View.INVISIBLE);
            }
        }
    };
    View.OnClickListener btnDraugiCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent nIntent = new Intent(NewEvent.this, Friends.class);
            startActivity(nIntent);
        }
    };
}
