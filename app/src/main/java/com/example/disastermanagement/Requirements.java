package com.example.disastermanagement;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Requirements extends AppCompatActivity {

    ProgressBar prg, prg2, prg3;

    DatabaseReference reference, reference2, reference3;
    Button b1;
    String a = "1";
    TextView tv1,tv2,tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirements);
        Intent intent=getIntent();
        String position=intent.getExtras().getString("position");
        a=position;



        prg = (ProgressBar)findViewById(R.id.progressbar);
        prg2 = (ProgressBar)findViewById(R.id.progressbar2);
        prg3 = (ProgressBar)findViewById(R.id.progressbar3);


        b1 = (Button) findViewById(R.id.button);

        reference = FirebaseDatabase.getInstance().getReference().child("Disasters").child(a).child("Requirements").child("Food");
        reference2 = FirebaseDatabase.getInstance().getReference().child("Disasters").child(a).child("Requirements").child("Livelihood");
        reference3 = FirebaseDatabase.getInstance().getReference().child("Disasters").child(a).child("Requirements").child("Shelter");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String achieved = dataSnapshot.child("Achieved").getValue().toString();


                String target = dataSnapshot.child("Target").getValue().toString();


                Double num1=Double.parseDouble(achieved);
                Double num2=Double.parseDouble(target);
                Double x=num1/num2*100;


                int y=(int) Math.round(x);

                prg.setProgress(y);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String achieved = dataSnapshot.child("Achieved").getValue().toString();


                String target = dataSnapshot.child("Target").getValue().toString();


                Double num1=Double.parseDouble(achieved);
                Double num2=Double.parseDouble(target);
                Double x=num1/num2*100;


                int y=(int) Math.round(x);

                prg2.setProgress(y);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String achieved = dataSnapshot.child("Achieved").getValue().toString();


                String target = dataSnapshot.child("Target").getValue().toString();


                Double num1=Double.parseDouble(achieved);
                Double num2=Double.parseDouble(target);
                Double x=num1/num2*100;


                int y=(int) Math.round(x);

                prg3.setProgress(y);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    Intent i = new Intent(Requirements.this,payment.class);
                    startActivity(i);


            }
        });


    }


}
