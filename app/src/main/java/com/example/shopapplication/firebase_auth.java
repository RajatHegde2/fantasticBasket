package com.example.shopapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class firebase_auth {

    public static void firebase_interact(String id,String pass,String addr,String name) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myReff = database.getReference("mybook");
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child(id).child("userid").setValue(id);
        mDatabase.child(id).child("password").setValue(pass);
        mDatabase.child(id).child("name").setValue(addr);
        mDatabase.child(id).child("address").setValue(name);


    }
    public static void firebaseShopcountEntry(String[] a,int[] b)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myReff = database.getReference(idtopass);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        for(int i=0;i<a.length;i++) {
            mDatabase.child(idtopass).child("veg").child(a[i]).setValue(b[i]);
        }
    }
    public static String a;
    public static String passa;
    public static TextView n;
    public static int p=0;
    public static String idtopass;
    public static void firebase_query(String id, String pass, TextView view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myReff = database.getReference(id);
        passa=pass;
        n=view;
        idtopass=id;
        myReff.child("password").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                    if((a=dataSnapshot.getValue().toString()).equals(passa))
                    {
                       n.setText("Verified! Click login");
                       p=1;
                    }
                    else
                    {
                        n.setText("Password doesn't match");

                    }

                }
                else
                {
                    n.setText("No user found with matching user id!!");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
