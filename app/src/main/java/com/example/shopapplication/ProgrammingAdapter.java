package com.example.shopapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder> {
    public static int j=0;
    private String[] data;
    private int[] imageint;
    private onNoteListnerme monNoteListner;
    public ProgrammingAdapter(String[] data,int[] imageint,onNoteListnerme p )
    {
        monNoteListner=p;
        this.imageint=imageint;
        this.data=data;
    }
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view =inflater.inflate(R.layout.list_layout_file,viewGroup,false);

        return new ProgrammingViewHolder(view,monNoteListner);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProgrammingViewHolder programmingViewHolder, int i) {
        String title=data[i];
        programmingViewHolder.txtTitle.setText(title);
        programmingViewHolder.imgicon.setImageResource(imageint[i]);
        // programmingViewHolder.p.setImageResource(imageint[i]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgicon,p;
        TextView txtTitle,showdata;
        Button b1,b2;
        LinearLayout l;
        String s;
        onNoteListnerme OnNoteListner;

        public ProgrammingViewHolder(@NonNull View itemView,onNoteListnerme OnNoteListener) {
            super(itemView);
            imgicon=itemView.findViewById(R.id.imgicon);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            //   p=itemView.findViewById(R.id.Button1);
            //b2=itemView.findViewById(R.id.button2);

            this.OnNoteListner=OnNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // showdata=v.findViewById(R.id.textdisplay);
            //s=showdata.getText().toString();
            s="ihwh";
            OnNoteListner.onNoteClickme(getAdapterPosition(),s);

        }
    }
    public interface onNoteListnerme
    {
        void onNoteClickme(int position,String s);
    }
}
