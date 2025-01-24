package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ComplaintActivity extends AppCompatActivity {
EditText date, name, address, complaint,complaint_type;

Button btn,btn1;
int year;
int month;
int day;




    String[] items={"Street Light", "Pipe Leakage","Rain Water","Road Reconstruct","Garbage"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_complaint);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        complaint=findViewById(R.id.complaint);
        btn=findViewById(R.id.button);
        date=findViewById(R.id.date);
        btn1=findViewById(R.id.btn2);
        autoCompleteTextView=findViewById(R.id.auto);

        adapterItems=new ArrayAdapter<String>(this, R.layout.list_items,items);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(ComplaintActivity.this, "Item "+item, Toast.LENGTH_SHORT).show();
            }
        });




        Calendar calendar = Calendar.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog =new DatePickerDialog(ComplaintActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));

                    }
                }, year,month,day);
                datePickerDialog.show();
            }
        });


btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        processinsert(name.getText().toString(),address.getText().toString(),date.getText().toString(),autoCompleteTextView.getText().toString(),complaint.getText().toString());
//        String username=name.getText().toString();
//        String useraddress=address.getText().toString();
//        String userdate=date.getText().toString();
//        String usercomplaint_type=autoCompleteTextView.getText().toString();
//        String usercomplaint=complaint.getText().toString();

    }
});


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComplaintActivity.this,fetchdata.class));
            }
        });



    }
    public void processinsert(String n, String a, String d, String ct, String c) {
        String res = new dbmanager(this).addrecord(n, a, d, ct, c);
        name.setText("");
        address.setText("");
        date.setText("");
        autoCompleteTextView.setText("");
        complaint.setText("");
        if (autoCompleteTextView.length() == 0 || date.length() == 0) {
            Toast.makeText(this, "fill all details", Toast.LENGTH_SHORT).show();
        } else {


            Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
        }
    }


}