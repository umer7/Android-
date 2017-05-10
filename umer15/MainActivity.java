package com.example.umer.umer15;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import  android.widget.Button;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button mybButton =(Button)findViewById(R.id.mybut);
        mybButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView myView=(TextView)findViewById(R.id.mytext);
                        myView.setText("Good");

                    }
                }
        );

        mybButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView myView=(TextView)findViewById(R.id.mytext);
                        myView.setText("It's long one");
                        return true;
                    }
                }
        );


    }
}
