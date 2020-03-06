package com.example.disastermanagement;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    EditText e1, e2, e3;
    TextView t1;
    Button b1;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        e1 = (EditText) findViewById(R.id.editText13);
        e2 = (EditText) findViewById(R.id.editText14);
        e3 = (EditText) findViewById(R.id.editText15);

        t1 = (TextView) findViewById(R.id.login);

        b1 = (Button) findViewById(R.id.button3);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e1.getText().toString().trim();
                String email = e2.getText().toString().trim();
                String phone = e3.getText().toString().trim();

                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(phone)){
                    Toast.makeText(signup.this, "Please Enter all details", Toast.LENGTH_SHORT).show();
                    return;
                }else{

                    databaseReference.child(phone).child("Name").setValue(name);
                    databaseReference.child(phone).child("Email").setValue(email);
                    databaseReference.child(phone).child("Phone").setValue(phone);

                    Toast.makeText(signup.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();

                    Intent i =  new Intent(signup.this, Home.class);
                    i.putExtra("phno",phone);
                    startActivity(i);
                }


            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signup.this, Login.class);
                startActivity(i);
            }
        });
    }
}
