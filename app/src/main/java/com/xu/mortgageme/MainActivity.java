package com.xu.mortgageme;

import android.content.Context;
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
import android.widget.Button;

//Uses Activity main, opening page
public class MainActivity extends AppCompatActivity {
    Button launchcar;
    Button launchmortgage;
    Boolean questions;
    SharedPreferences sp;
    SharedPreferences.Editor edit;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       sp = getSharedPreferences("mode", Context.MODE_PRIVATE);
       edit= sp.edit();

        launchcar =(Button) findViewById(R.id.btnloan);
        launchmortgage  =(Button)findViewById(R.id.btnmortgage);

        launchcar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                questions=true;
                edit.putBoolean("mode",questions);
                edit.commit();

                //True status indicates we are considering car loan
                Intent launch= new Intent(MainActivity.this, questionActivity.class);
                startActivity(launch);
            }
        });

       launchmortgage.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               questions=false;
               edit.putBoolean("mode",questions);
               edit.commit();

               //True status indicates we are considering car loan
               Intent launch= new Intent(MainActivity.this, questionActivity.class);
               startActivity(launch);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}