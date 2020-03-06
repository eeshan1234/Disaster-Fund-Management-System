package com.example.disastermanagement;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kofigyan.stateprogressbar.StateProgressBar;

public class tracking extends AppCompatActivity {

    String[] descriptionData = {"Step One", "Step Two", "Step Three"};
    //Button b;
    DatabaseReference databaseReference;
    Button hom,ack;
    String ph="8777022293";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        //b = (Button) findViewById(R.id.button);
        String id;
        tv=findViewById(R.id.tv);
        Intent i;
        i=getIntent();
        id=i.getExtras().getString("id");
        //Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(ph).child("payments").child(id);

        final StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.your_state_progress_bar_id);
        stateProgressBar.setStateDescriptionData(descriptionData);

        tv.setText("Payment id: "+id);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s = dataSnapshot.child("Flag1").getValue().toString();
                String s2 = dataSnapshot.child("Flag2").getValue().toString();

                Toast.makeText(tracking.this, ""+s+s2, Toast.LENGTH_SHORT).show();

               int x = Integer.parseInt(s);
               int y = Integer.parseInt(s2);

               // Toast.makeText(tracking.this, ""+x+y, Toast.LENGTH_SHORT).show();

                switch (stateProgressBar.getCurrentStateNumber()) {

                    case 1:
                        if (x == 1) {
                            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        } else {
                            break;
                        }

                    case 2:
                        if (y == 1) {
                            stateProgressBar.setAllStatesCompleted(true);
                        } else {
                            break;
                        }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}
