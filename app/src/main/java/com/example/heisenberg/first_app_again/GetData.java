package com.example.heisenberg.first_app_again;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by heisenberg on 11/12/17.
 */

public class GetData extends AppCompatActivity implements View.OnClickListener {

    EditText et7;
    Button btn1, btn2Res;
    TextView tv7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        initializeComponents();
    }

    private void initializeComponents() {
        et7 = (EditText) findViewById(R.id.editText7);
        btn1 = (Button) findViewById(R.id.btnWithoutResult);
        btn2Res = (Button) findViewById(R.id.btnForResult);
        tv7 = (TextView) findViewById(R.id.textView7);
        btn1.setOnClickListener(this);
        btn2Res.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String str = String.valueOf(et7.getText());
        Bundle dataBundle = new Bundle();
        dataBundle.putString("str_data",str);
        switch (view.getId()){
            case R.id.btnWithoutResult:
                Intent i = new Intent(GetData.this, SendData.class);
                i.putExtras(dataBundle);
                startActivity(i);
                break;
            case R.id.btnForResult:
                Intent i2 = new Intent(GetData.this, SendData.class);
                i2.putExtras(dataBundle);
                startActivityForResult(i2, 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle b = data.getExtras();
            String s = (String) b.get("ret_data");
            tv7.setText(s);
        }
    }
}
