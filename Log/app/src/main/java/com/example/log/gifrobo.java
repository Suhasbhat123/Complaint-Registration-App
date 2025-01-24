package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class gifrobo extends AppCompatActivity {
Button btn1,btn2;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifrobo);
        btn1=findViewById(R.id.comp1);
        btn2=findViewById(R.id.tip);
        img=findViewById(R.id.close);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(gifrobo.this,ComplaintActivity.class));
            }
        });
    }
       public void exit(View v)
        {
            finish();
        }
        public void safe(View v)
        {
            System.out.println("coming");
        }


}