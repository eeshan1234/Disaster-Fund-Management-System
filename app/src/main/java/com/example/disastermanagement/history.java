package com.example.disastermanagement;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class history extends AppCompatActivity {

    ArrayList<FireModelH> list;
    RecyclerView recyclerView;

    int i=0;
    String title,date,name;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView=findViewById(R.id.recycleh);

        Intent intent=getIntent();
        String phno=intent.getExtras().getString("phno","8777022293");

        Toast.makeText(this, ""+phno, Toast.LENGTH_SHORT).show();
        DatabaseReference db= FirebaseDatabase.getInstance().getReference("Users").child(phno).child("payments");
        //  progressBar=findViewById(R.id.pbar);


        recyclerView.clearOnScrollListeners();
        recyclerView.clearOnChildAttachStateChangeListeners();
        // list.clear();
        list=new ArrayList<FireModelH>();

        db.addValueEventListener(new ValueEventListener() {
            FireModelH fireModel=new FireModelH();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                FireModelH value;
                list.clear();
               // Toast.makeText(history.this, "Hello", Toast.LENGTH_SHORT).show();
                for(DataSnapshot x:dataSnapshot.getChildren())
                {
                    value=x.getValue(FireModelH.class);
                    list.add(value);
                    // Toast.makeText(Main2Activity.this, "item: "+list.get(i).title, Toast.LENGTH_LONG).show();
                   // Toast.makeText(history.this, "Item: "+value, Toast.LENGTH_SHORT).show();

                }
                recyclerView.clearOnScrollListeners();
                recyclerView.clearOnChildAttachStateChangeListeners();


                Adapterhistory adapterhistory= new Adapterhistory(list);
                RecyclerView.LayoutManager recyce=new GridLayoutManager(recyclerView.getContext(),1);
                recyclerView.setLayoutManager(recyce);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapterhistory);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}

