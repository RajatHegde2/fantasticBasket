package com.example.shopapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import okio.Timeout;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public static int count=0;
    public void onClickLogin(View view)
    {
        for(int i=0;i<MiniAdapter.maga.length;i++)
        {
            MiniAdapter.maga[i]=0;
        }
        TextView e=findViewById(R.id.test1);
        EditText f=findViewById(R.id.idlog);
        EditText p=findViewById(R.id.passlog);
        String id=f.getText().toString();
        String pass=p.getText().toString();
       firebase_auth.firebase_query(id,pass,e);
        // int interval = 5000; // 1 Second
        //Handler handler = new Handler();
        TextView t=findViewById(R.id.logagain);
        firebase_auth.firebase_query(id,pass,t);

        if(firebase_auth.p==1) {
            Intent jk = new Intent(this, MainActivity.class);
            firebase_auth.p=0;
            startActivity(jk);
        }
        else
        {

        }






        //onClickLogin(view);
       // Intent i=new Intent(this,MainActivity.class);
        //startActivity(i);
    }
    public void onClickVerify(View view)
    {
        firebase_auth.p=0;
        onClickLogin(view);
    }
    public void onClickRegister(View view)
    {
        firebase_auth.p=0;
        Intent i=new Intent(this,Register.class);

        startActivity(i);
        finish();
    }
}
