package com.example.heisenberg.first_app_again;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter;
    Button add, sub;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        add = (Button) findViewById(R.id.buttonadd);
        sub = (Button) findViewById(R.id.buttonsub);
        display = (TextView) findViewById(R.id.txt);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter+=1;
                display.setText("Your total is "+counter);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter-=1;
                display.setText("Your total is "+counter);
            }
        });
    }


}
