package com.example.shopapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    public static String cost[]={"26","12","35","67","89","76","54","34"};
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String a;
        int quan;
        int sum;
        int tsum=0;
        TextView t=findViewById(R.id.showresult);

        for(int i=0;i<Main2Activity.a.length;i++)
        {
            quan=MiniAdapter.maga[i];
            if(quan==0)
                continue;
            sum=quan*(Integer.parseInt(cost[i]));
            a="\n"+Main2Activity.a[i]+" : "+quan+" X "+cost[i]+" = "+sum+"Rupees\n";
            tsum+=sum;
            t.append(a);
        }
        a="\nTotal Cost is "+tsum+"Rupees\n";
        t.append(a);
    }
}
