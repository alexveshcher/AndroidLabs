package com.naukma.alex.lab4intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {
    public final static String NAME = "NAME";
    public final static String SURNAME = "SURNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }

    public void login(View view) {
        EditText t1 = (EditText) findViewById(R.id.name);
        EditText t2 = (EditText) findViewById(R.id.surname);
        String name = t1.getText().toString();
        String surname = t2.getText().toString();
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra(NAME, name);
        intent.putExtra(SURNAME, surname);


        startActivity(intent);
    }
}
