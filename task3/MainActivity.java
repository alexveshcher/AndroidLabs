package com.naukma.alex.task3sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    DatabaseHelper myDb;
    String title[] = { "Android", "Prolog"};
    String descr[] = { "Dedline on Saturday", "Dedline on Tuesday" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Todo t1 = new Todo(1,"Android","lol");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        db = myDb.getReadableDatabase();

        /*ContentValues values = new ContentValues();
        values.put("title", t1.getTitle());
        values.put("descr", t1.getDescr());
        db.insert("todos_table", null, values);
        */
        String title = "Android";
        Cursor c = db.rawQuery("select * from todos_table", null);
        c.moveToFirst();
        Toast.makeText(getApplicationContext(), c.getInt(0)+" "+c.getString(1)+" "+c.getString(2), Toast.LENGTH_LONG).show();
        //Log.d("zazazazaz",c.getString(1));
    }
}
