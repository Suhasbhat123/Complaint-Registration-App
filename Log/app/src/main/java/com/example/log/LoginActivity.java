package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    TextView text;
    EditText userEdit, passEdit;
int attempt=1;
    Button loginBtn;
    ImageView btn1, btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_main);
        text=findViewById(R.id.sign);
        userEdit=findViewById(R.id.editTextTextPersonName);
        passEdit=findViewById(R.id.editTextTextPassword);
        loginBtn=findViewById(R.id.loginBtn);
        btn1=findViewById(R.id.facebook);
        btn2=findViewById(R.id.google);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = userEdit.getText().toString();
                String password = passEdit.getText().toString();
                Database db = new Database(getApplicationContext(), "Complaint_Registration", null, 1);
                if (attempt <= 2) {
                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {


                        if (db.login(username, password) == 1) {
                            Toast.makeText(getApplicationContext(), "login Success", Toast.LENGTH_SHORT).show();
                            SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString("username", username);
                            editor.apply();

                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid Username and Password and attempt is "+attempt, Toast.LENGTH_LONG).show();
                        }
                    }
                    }
                if(attempt==2){
                  loginBtn.setEnabled(false);
                }
                attempt++;
                }
        });


        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( LoginActivity.this, registerActivity.class));

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myLink = new Intent(Intent.ACTION_VIEW);
                myLink.setData(Uri.parse("https://accounts.google.com/v3/signin/identifier?dsh=S-1391600151%3A1681908999762466&continue=https%3A%2F%2Faccounts.google.com%2F&followup=https%3A%2F%2Faccounts.google.com%2F&ifkv=AQMjQ7T1S3IFdfQVvAES_n0n_9dxM98IT5nadKbcnyVYEDUqq40e7JeQ2qAHgXmid1OFOF2yWMbX5Q&passive=1209600&flowName=GlifWebSignIn&flowEntry=ServiceLogin"));
                startActivity(myLink);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myLink = new Intent(Intent.ACTION_VIEW);
                myLink.setData(Uri.parse("https://www.facebook.com/login/"));
                startActivity(myLink);
            }
        });




    }
}