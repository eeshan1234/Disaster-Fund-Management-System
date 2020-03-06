package com.example.disastermanagement;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapterhistory  extends RecyclerView.Adapter<Adapterhistory.MyViewHolder1> {
    private List<FireModelH> userList;
    LinearLayout linearLayout;
    //  DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Disasters");
    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView img;
        public  TextView date,name;

        public MyViewHolder1(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            //img=view.findViewById(R.id.pic);
          //  date=view.findViewById(R.id.date);
            name=view.findViewById(R.id.name);

            linearLayout=view.findViewById(R.id.idh);


        }
    }


    public Adapterhistory(List<FireModelH> moviesList) {
        this.userList = moviesList;
    }

    @Override
    public MyViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardh, parent, false);

        return new MyViewHolder1(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder1 holder1, final int position) {
        FireModelH user = userList.get(position);
        holder1.name.setText(user.getTitle());

        holder1.title.setText(user.getLink());
        //Picasso.get().load(user.getLink()).into(holder.img);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(v.getContext(), "Opening! Please wait.....", Toast.LENGTH_LONG).show();

                //Intent i=new Intent(v.getContext(),MainActivity.class);
                //i.putExtra("position",""+(position+1));
                //v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}