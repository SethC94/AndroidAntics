package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.JokeLibrary;
import com.example.androidantics.AndroidAntics;


public class MainActivity extends AppCompatActivity {

    public final static String INTENT_KEY = "JOKE_INTENT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
        setContentView(R.layout.activity_main);

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

    public void getJoke(View view) {
        Intent intent = new Intent(this, AndroidAntics.class);
        JokeLibrary jokeSource = new JokeLibrary();
        String joke = jokeSource.getJoke();
        intent.putExtra(AndroidAntics.INTENT_KEY, joke);
        startActivity(intent);

    }

}