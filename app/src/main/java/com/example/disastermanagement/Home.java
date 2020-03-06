package com.example.disastermanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
public class Home extends AppCompatActivity {

    CardView cdhistory,cdachieve,cdtrack,cddonate;

    ImageView bgapp, clover;
    LinearLayout textsplash, texthome, menus;
    Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);



        bgapp = (ImageView) findViewById(R.id.bgapp);
        clover = (ImageView) findViewById(R.id.clover);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);

        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(100).setStartDelay(800);
        textsplash.animate().translationY(540).alpha(0).setDuration(900).setStartDelay(500);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);
        cdhistory=findViewById(R.id.cdhistory);
        cdachieve=findViewById(R.id.cdachieve);
        cdtrack=findViewById(R.id.cdtrack);
        cddonate=findViewById(R.id.cddonate);

        cddonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,MainActivity.class);
                Intent intent=getIntent();
                String phno=intent.getExtras().getString("phno","8777022293");
                i.putExtra("phno",phno);
                startActivity(i);
            }
        });
        cdhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,history.class);
                Intent intent=getIntent();
                String phno=intent.getExtras().getString("phno","8777022293");
                i.putExtra("phno",phno);
                startActivity(i);
            }
        });
        cdachieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,Chat.class);
                startActivity(i);
               // Toast.makeText(Home.this, "Achievements", Toast.LENGTH_SHORT).show();
            }
        });
        cdtrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,Search.class);
                startActivity(i);
//                Intent intent=getIntent();
//                String phno=intent.getExtras().getString("phno","8777022293");
//                i.putExtra("phno",phno);
//                Toast.makeText(Home.this, "Tracking", Toast.LENGTH_SHORT).show();
            }
        });

    }
}


//




