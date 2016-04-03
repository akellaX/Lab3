package com.example.anna.lab3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Login) {
            Intent intent= new Intent(this,LoginActivity.class);
            startActivity(intent);
            return true;
        }
        else
        if (id == R.id.Registration) {
            Intent intent= new Intent(this,RegestrationActivity.class);
            startActivity(intent);
            return true;
        }
        else
        if (id == R.id.Exit) {
            this.finishAffinity();
        }
        else {
            if (id == R.id.Clear)
                sp = getSharedPreferences("mypref", MODE_PRIVATE);
            edit = sp.edit();
            edit.clear();
            edit.commit();

        }


        return super.onOptionsItemSelected(item);
    }
}
