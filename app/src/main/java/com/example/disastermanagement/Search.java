package com.example.disastermanagement;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Search extends AppCompatActivity {

    EditText e1;
    Button b1;

    DatabaseReference databaseReference;

    String ph="8777022293";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        e1 = (EditText)findViewById(R.id.edittext);
        b1 = (Button)findViewById(R.id.button);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(ph).child("payments");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String id = e1.getText().toString();

                        for(DataSnapshot x:dataSnapshot.getChildren() ) {

                            if (x.getKey().equals(id)) {
                                Intent i = new Intent(Search.this, tracking.class);
                                i.putExtra("id", id);
                                startActivity(i);
                            } else {
                                Toast.makeText(Search.this, "Payment ID not found", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}
