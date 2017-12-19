package com.example.sunlight1.http;

/**
 * Created by sunlight1 on 10/29/2017.
 */


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sunlight1 on 10/13/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context context;
    String des,phoneNo;
    private LayoutInflater inflater;
    String [] ids;
    String [] name;
    String [] email;
    String [] roomno;

    private List<Teacherslist> teacherslists ;

    public RecyclerAdapter(Context context, List<Teacherslist> contact) {


        this.teacherslists = contact;
        this.context = context;

        inflater = LayoutInflater.from(context);


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.customview,parent,false);
        // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        final Teacherslist contact = teacherslists.get(position);



        des = contact.getDesignation();
        phoneNo = contact.getPhone();
        holder.id.setText(String.valueOf(contact.getId()));
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getRoomno());
        holder.email.setText(contact.getEmail());


       // Picasso.with(context).load("www.journaldev.com").placeholder(R.drawable.uh).into(holder.imageView);

//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("Click", "onClick: Hi "+ holder.id.getText().toString());
//
////                String pervious =holder.name.getText().toString();
////                contact1.remove(position);
////                notifyItemRemoved(position);
////                notifyItemRangeChanged(position,contact1.size());
////
////                Toast.makeText(context, "Removed: "+pervious, Toast.LENGTH_SHORT).show();
//
//            }
//        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView id = view.findViewById(R.id.id);
                TextView name = view.findViewById(R.id.name);
                TextView phone = view.findViewById(R.id.phone);
                TextView email = view.findViewById(R.id.email);
                ImageView imageView = view.findViewById(R.id.imageView);
               Picasso.with(context).load("http://192.168.101.1/test/kk.jpg").placeholder(R.drawable.abd).into(imageView);


                String idS,nameS,room,emailS;

                idS = id.getText().toString();
                nameS = name.getText().toString();
                room = phone.getText().toString();
                emailS = email.getText().toString();

                Intent intent = new Intent(context,Details.class);
                intent.putExtra("name",nameS);
                intent.putExtra("des",des);
                intent.putExtra("email",emailS);
                intent.putExtra("phone",phoneNo);
                intent.putExtra("room",room);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);

            }
        });


    }


    @Override
    public int getItemCount() {
        return teacherslists.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView id,name,email,phone;
        Button button;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.id = (TextView) itemView.findViewById(R.id.id);
            this.name = (TextView)itemView.findViewById(R.id.name);
            this.email = (TextView)itemView.findViewById(R.id.phone);
            this.phone = (TextView)itemView.findViewById(R.id.email);
            this.image = (ImageView) itemView.findViewById(R.id.imageView);
            //this.button = (Button) itemView.findViewById(R.id.button);

        }
    }


}

