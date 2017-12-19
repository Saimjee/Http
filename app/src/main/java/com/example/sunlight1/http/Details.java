package com.example.sunlight1.http;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    String name,des,room,phone,email;
    TextView nameT,desT,roomT,phoneT,emailT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameT= (TextView) findViewById(R.id.name);
        desT= (TextView) findViewById(R.id.des);
        roomT= (TextView) findViewById(R.id.room);
        phoneT= (TextView) findViewById(R.id.phone);
        emailT= (TextView) findViewById(R.id.email);


        Intent intent = getIntent();
        name=intent.getStringExtra("name");
        des=intent.getStringExtra("des");
        room=intent.getStringExtra("room");
        phone=intent.getStringExtra("phone");
        email=intent.getStringExtra("email");

        nameT.setText(name);
        desT.setText(des);
        roomT.setText(room);
        phoneT.setText(phone);
        emailT.setText(email);


    }
}
