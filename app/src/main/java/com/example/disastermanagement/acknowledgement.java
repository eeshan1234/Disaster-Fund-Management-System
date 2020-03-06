package com.example.disastermanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class acknowledgement extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledgement);

        tv=findViewById(R.id.ack);

        Intent intent=getIntent();
        String id=intent.getExtras().getString("id","123");

        tv.setText("Payment Id: "+id);
    }
}
