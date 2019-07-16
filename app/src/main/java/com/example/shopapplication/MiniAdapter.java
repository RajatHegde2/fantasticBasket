package com.example.shopapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MiniAdapter extends RecyclerView.Adapter<MiniAdapter.ProgrammingViewHolder> {

    public static int[] maga={0,0,0,0,0,0,0,0};
    private String[] data;
    private int[] imageint;
    private String[] zerodata;
    private int[] plus;
    private int[] minus;
    private String[] cost;
    private onNoteListner monNoteListner;
    public MiniAdapter(String[] data,int[] imageint,String[] zerodata,int[] e,int[] f,String[] cost,onNoteListner p )
    {
        this.cost=cost;
        monNoteListner=p;
        this.imageint=imageint;
        this.data=data;
        this.zerodata=zerodata;
        plus=e;
        minus=f;
    }
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view =inflater.inflate(R.layout.list_specific,viewGroup,false);

        return new ProgrammingViewHolder(view,monNoteListner);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProgrammingViewHolder programmingViewHolder, int i) {
        String title=data[i];
        programmingViewHolder.title1.setText(title);
        programmingViewHolder.title2.setText(cost[i]);
        programmingViewHolder.imgicon.setImageResource(imageint[i]);
        programmingViewHolder.showdata.setText(Integer.toString(maga[i]));
        programmingViewHolder.b1.setImageResource(plus[i]);
        programmingViewHolder.b2.setImageResource(minus[i]);
        // programmingViewHolder.p.setImageResource(imageint[i]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgicon,p;
        LinearLayout txtTitle;
        TextView title1,title2,showdata;
        ImageView b1,b2;
        LinearLayout l;

        String s;
        onNoteListner OnNoteListner;

        public ProgrammingViewHolder(@NonNull View itemView,onNoteListner OnNoteListener) {
            super(itemView);
            imgicon=itemView.findViewById(R.id.imgicon);
            title1=itemView.findViewById(R.id.title1);
            title2=itemView.findViewById(R.id.title2);
            b1=itemView.findViewById(R.id.b1);
            b2=itemView.findViewById(R.id.b2);
            //   p=itemView.findViewById(R.id.Button1);
            //b2=itemView.findViewById(R.id.b2);
            showdata=itemView.findViewById(R.id.data);
            this.OnNoteListner=OnNoteListener;
            b1.setOnClickListener(this);
            b2.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // showdata=v.findViewById(R.id.textdisplay);
            //s=showdata.getText().toString();

            switch (v.getId())
            {
                case R.id.b1:
                    showdata.setText(Integer.toString(++maga[getAdapterPosition()]));
                    break;
                case R.id.b2:
                    if(maga[getAdapterPosition()]==0)
                        break;
                    showdata.setText(Integer.toString(--maga[getAdapterPosition()]));
                    break;

            }

            OnNoteListner.onNoteClick(getAdapterPosition(),s);

        }
    }
    public interface onNoteListner
    {
        void onNoteClick(int position,String s);
    }
}
