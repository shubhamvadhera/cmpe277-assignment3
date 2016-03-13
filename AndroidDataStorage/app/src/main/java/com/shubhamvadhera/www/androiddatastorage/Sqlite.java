package com.shubhamvadhera.www.androiddatastorage;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sqlite extends AppCompatActivity {
    SqliteDb mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mydb = new SqliteDb(this);
    }

    public void finishSqlite (View view) {
        finish();
    }

    public void saveSqlite(View view) {

        EditText editText = (EditText) findViewById(R.id.editTextSqlName);
        String bookName = editText.getText().toString();
        if (bookName.isEmpty()) {
            Toast.makeText(this, "Please enter book name", Toast.LENGTH_SHORT).show();
            return;
        }
        editText = (EditText) findViewById(R.id.editTextSqlAuth);
        String authorName =  editText.getText().toString();
        editText = (EditText) findViewById(R.id.editTextSqlDesc);
        String bookDesc = editText.getText().toString();
        Log.d("bookName -> ", bookName);
        Log.d("authorName -> ", authorName);
        Log.d("bookDesc -> ", bookDesc);
        if (mydb.insertRecord(bookName, authorName, bookDesc) > -1)
            Toast.makeText(this, "Saved !", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

}
