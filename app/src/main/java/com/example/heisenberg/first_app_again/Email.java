package com.example.heisenberg.first_app_again;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by heisenberg on 11/5/17.
 */

public class Email extends AppCompatActivity implements View.OnClickListener {

    EditText fname, lname, address, email, intro, random;
    String str_fname, str_lname, str_address, str_email, str_intro, str_random;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initializeComponents();
        btn.setOnClickListener(this);
    }

    private void initializeComponents() {
        fname = (EditText) findViewById(R.id.editText);
        lname = (EditText) findViewById(R.id.editText2);
        address = (EditText) findViewById(R.id.editText3);
        email = (EditText) findViewById(R.id.editText4);
        intro = (EditText) findViewById(R.id.editText5);
        random = (EditText) findViewById(R.id.editText6);
        btn = (Button) findViewById(R.id.emailbutton);
    }

    @Override
    public void onClick(View view) {
        extractText();
        String emailAdress[] = {str_email};
        String msg = "Something " +
                "Something line2 " +
                str_fname + str_lname +
                "how about this as well" +
                str_address + str_intro +
                "and finally this " +
                str_random;

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, emailAdress);
        email.putExtra(Intent.EXTRA_SUBJECT, str_intro);
        email.setType("plain/text");
        email.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(email);
    }

    private void extractText() {
        str_fname = fname.getText().toString();
        str_lname = lname.getText().toString();
        str_address = address.getText().toString();
        str_email = email.getText().toString();
        str_intro = intro.getText().toString();
        str_random = random.getText().toString();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
