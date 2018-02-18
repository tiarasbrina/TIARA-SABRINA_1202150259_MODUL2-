package com.example.tiara.tiarasabrina_1202150259_modul2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

//membuat variable untuk menampung nilai
public class TakeAway extends AppCompatActivity {
private EditText name, phone, address, note;
private EditText editTextDate, editTextTime;
int hour, minute, mYear, mMonth, mDay;
static final int TIME_DIALOG_ID = 0;
static final int DATE_DIALOG_ID = 1;
private String[] arrMonth = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);

        //mengambil nilai dan menyimpannya di variable
        name = (EditText) findViewById(R.id.namePemesan);
        phone = (EditText) findViewById(R.id.phonePemesan);
        address = (EditText) findViewById(R.id.addressPemesan);
        note = (EditText) findViewById(R.id.notePemesan);
        editTextDate= (EditText) findViewById(R.id.date);
        editTextTime= (EditText) findViewById(R.id.time);
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        //membuat event editTextDate jika diklik
        editTextDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(DATE_DIALOG_ID);
                return true;
            }
        });
        //membuat event editTextTime jika diklik
        editTextTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(TIME_DIALOG_ID);
                return true;
            }
        });
    }

    //menampilkan event timepicker dan datepicker
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(
                        this, mTimeSetListener, hour, minute, true);
            case DATE_DIALOG_ID:
                return new DatePickerDialog(
                        this, mDateSetListener, mYear, mMonth, mDay);
        }
        return null;
    }

    //mengembalikan date dan time yang telah diatur ke editTextDate
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            String sdate = arrMonth[mMonth] + " " + LPad(mDay + "", "0", 2) + ", " + mYear;
            editTextDate.setText(sdate);
        }
    };
    //mengembalikan date dan time yang telah diatur ke editTextTime
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
            hour = hourOfDay;
            minute = minuteOfHour;
            String stime = LPad("" + hour, "0", 2) + ":" + LPad("" + hour, "0", 2);
            editTextTime.setText(stime);
        }
    };

    //membuat perulangan
    private static String LPad(String schar, String spad, int len) {
        String sret = schar;
        for (int i = sret.length(); i < len; i++) {
            sret = spad + sret;
        }
        return new String(sret);

    }
    //membuat aktifitas untuk btPilihPesan
    public void btPilihPesanan (View view){
        final String a = name.getText().toString();
        final String b = phone.getText().toString();
        final String c = address.getText().toString();
        final String d = note.getText().toString();
        //membuat kondisi jika salah satu kolom tidak diisi (kosong) akan muncul alert dialog pada screen
        if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty()){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Alert Message");
            alert.setMessage("Fill All the Coloumn First!")
                    .setCancelable(false)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alertDialog = alert.create();

            alertDialog.show();
        }
        //membuat kondisi, jika semua terisi maka akan masuk ke screen DaftarMenu
        else {
            Intent intent = new Intent(TakeAway.this, DaftarMenu.class);
            startActivity(intent);
        }

    }


}
