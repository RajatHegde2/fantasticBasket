package com.example.shopapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import static com.example.shopapplication.Main2Activity.a;

public class MainActivity extends AppCompatActivity implements ProgrammingAdapter.onNoteListnerme {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView programmingList=findViewById(R.id.programmingList);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        String[] a={"Vegetables","Grocery","Household","Snacks","Beverages"};
        int[] b={R.drawable.tomato,R.drawable.grocery,R.drawable.soap,R.drawable.lays,R.drawable.pepsi};
        programmingList.setAdapter(new ProgrammingAdapter(a,b,this));
    }
    public void onNoteClickme(int position,String s) {
        if(position==0){
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,Main2Activity.class);
            startActivity(i);
        }
    }
    public void onClickSubmit(View view )
    {
        firebase_auth.firebaseShopcountEntry(Main2Activity.a,MiniAdapter.maga);
        Intent i=new Intent(this,Main3Activity.class);
        startActivity(i);
    }
    public void onClickBack(View view)
    {
        Intent i=new Intent(this,Login.class);
        startActivity(i);
    }
}
