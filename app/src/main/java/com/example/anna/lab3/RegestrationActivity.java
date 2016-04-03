package com.example.anna.lab3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegestrationActivity extends AppCompatActivity {

    EditText name;
    EditText pass;
    EditText pass1;
    EditText name1;
    Button button;
    SharedPreferences sp;
    SharedPreferences.Editor edit;
    SharedPreferences sp1;
    SharedPreferences.Editor edit1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name1=(EditText) findViewById(R.id.editText6);
        name=(EditText) findViewById(R.id.editText3);
        pass=(EditText) findViewById(R.id.editText4);
        pass1=(EditText) findViewById(R.id.editText5);
        button=(Button) findViewById(R.id.button2);
        sp1=getSharedPreferences("namepref",MODE_PRIVATE);
        edit1=sp1.edit();
        sp= getSharedPreferences("mypref",MODE_PRIVATE);
        edit=sp.edit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namereal=name1.getText().toString();
                String name1=name.getText().toString();
                String password=pass.getText().toString();
                String password1=pass1.getText().toString();
                String check=sp.getString(name1, "");
                boolean flag=check.equals("");
                if(flag==false)
                    Toast.makeText(RegestrationActivity.this, "There is same login. Please try another.", Toast.LENGTH_SHORT).show();
                else


                if(password.equals(password1))
                {
                    edit1.putString(name1,namereal);
                    edit1.commit();
                    edit.putString(name1, password);
                    edit.commit();
                    String tmp=sp.getString(name1,"");
                    Toast.makeText(RegestrationActivity.this, "Record has been added.", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(RegestrationActivity.this, "Passwords are different", Toast.LENGTH_SHORT).show();


            }
        });


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
        else
        if(id==R.id.Clear) {
            sp = getSharedPreferences("mypref", MODE_PRIVATE);
            edit = sp.edit();
            edit.clear();
            edit.commit();

        }


        return super.onOptionsItemSelected(item);
    }
}