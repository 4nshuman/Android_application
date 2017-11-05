package com.example.heisenberg.first_app_again;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by heisenberg on 11/5/17.
 */

public class Menu extends ListActivity {

    String classes[] = {"MainActivity","TextPlay","example2","example3","example4","example5","example6",
            "example7","example8","example9","example10","example11","example12 "
    };

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Class activityClass = null;
        try {
            activityClass = Class.forName("com.example.heisenberg.first_app_again."+classes[position]);
            Intent newActivityIntent = new Intent(Menu.this, activityClass);
            startActivity(newActivityIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }
}
