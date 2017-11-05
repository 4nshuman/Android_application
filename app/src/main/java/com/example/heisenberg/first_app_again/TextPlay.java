package com.example.heisenberg.first_app_again;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by heisenberg on 11/5/17.
 */

public class TextPlay extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    ToggleButton tb1;
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);

        initialize_components();

        tb1.setOnClickListener(this);
        b1.setOnClickListener(this);
    }

    private void initialize_components() {
        b1 = (Button) findViewById(R.id.btnResults);
        tb1 = (ToggleButton) findViewById(R.id.tBPass);
        et = (EditText) findViewById(R.id.etxtbox);
        tv = (TextView) findViewById(R.id.tvResults);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnResults :
                String str = et.getText().toString();
                if (str.contentEquals("left")) {
                    tv.setText("Gravity set to left");
                    tv.setGravity(Gravity.LEFT);
                } else if (str.contentEquals("right")) {
                    tv.setText("Gravity set to right");
                    tv.setGravity(Gravity.RIGHT);
                } else if (str.contentEquals("center")) {
                    tv.setText("Gravity set to center");
                    tv.setGravity(Gravity.CENTER);
                } else if (str.contentEquals("blue")) {
                    tv.setText("Color set to blue");
                    tv.setTextColor(Color.BLUE);
                } else {
                    Random randVar = new Random();
                    tv.setText("Randomizing");
                    tv.setTextSize(randVar.nextInt(75));
                    tv.setTextColor(Color.argb(randVar.nextInt(), randVar.nextInt(), randVar.nextInt(), randVar.nextInt()));
                }
                break;

            case R.id.tBPass :
                if (tb1.isChecked()) {
                    et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    et.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;
        }
    }
}
