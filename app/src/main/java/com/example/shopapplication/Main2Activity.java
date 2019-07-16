package com.example.shopapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements MiniAdapter.onNoteListner {

    public static String[] a={"Potato","Onion","Tomato","Cauliflower","Broccoli","Lemon","Yellow Capsicum","Green Capsicum"};
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView programmingList=findViewById(R.id.programmingList1);
        programmingList.setLayoutManager(new LinearLayoutManager(this));

        String[] d={"0","0","0","0","0","0","0","0"};
        int[] e={R.drawable.plus,R.drawable.plus,R.drawable.plus,R.drawable.plus,R.drawable.plus,R.drawable.plus,R.drawable.plus,R.drawable.plus};
        int[] b={R.drawable.potato,R.drawable.onion,R.drawable.tomato,R.drawable.cauliflower,R.drawable.broccoli,R.drawable.lemon,R.drawable.yellowcaps,R.drawable.capsicum};
        int[] f={R.drawable.minus,R.drawable.minus,R.drawable.minus,R.drawable.minus,R.drawable.minus,R.drawable.minus,R.drawable.minus,R.drawable.minus};
        String[] costfromhere=new String[Main3Activity.cost.length];
        for(int i=0;i<Main3Activity.cost.length;i++)
        {
            costfromhere[i]="Rs "+Main3Activity.cost[i]+"/Kg";
        }
        programmingList.setAdapter(new MiniAdapter(a,b,d,e,f,costfromhere,this));

    }

    @Override
    public void onNoteClick(int position, String s)
    {

    }
    public void onClickSubmitsp(View view)
    {
        firebase_auth.firebaseShopcountEntry(a,MiniAdapter.maga);
        Intent i=new Intent(this,Main3Activity.class);
        startActivity(i);

    }
    public void onClickBacksp(View view)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);

    }
}
