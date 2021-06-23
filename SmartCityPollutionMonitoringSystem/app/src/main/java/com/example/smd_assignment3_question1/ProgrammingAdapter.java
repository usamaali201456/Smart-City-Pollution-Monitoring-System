package com.example.smd_assignment3_question1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.smd_assignment3_question1.R.layout.activity_recycler_view_layout_design;

public class ProgrammingAdapter extends RecyclerView.Adapter <ProgrammingAdapter.ProgrammingViewholder> {

    String [] names ;
    public ProgrammingAdapter(String [] names)
    {
        this.names=names ;
    }

    @NonNull
    @Override
    public ProgrammingViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.activity_recycler_view_layout_design,parent,false);
        return new ProgrammingViewholder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewholder holder, int position) {
        String Names=names[position];
        holder.textView.setText(Names);
    }

    @Override
    public int getItemCount() {
        return names.length ;
    }

    public class ProgrammingViewholder extends RecyclerView.ViewHolder{

        ImageView imgview ;
        TextView textView ;

        public ProgrammingViewholder(@NonNull View itemView) {
            super(itemView);
            imgview=itemView.findViewById(R.id.imageView4);
            textView=itemView.findViewById(R.id.textView10);



        }
    }

}
