package com.example.shopapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void onClickRegister(View view){
        EditText oid=findViewById(R.id.id);
        EditText oaddr=findViewById(R.id.addr);
        EditText oname=findViewById(R.id.name);
        EditText opass=findViewById(R.id.pass);
        String id=oid.getText().toString();
        String name=oname.getText().toString();
        String addr=oaddr.getText().toString();
        String pass=opass.getText().toString();



        firebase_auth.firebase_interact(id,pass,addr,name);
        Intent i=new Intent(this,Login.class);
        startActivity(i);
        finish();
    }
}
