package com.example.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String joke = bundle.getString("joke", "No joke available");

        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();

        TextView jokeView = (TextView) findViewById(R.id.joke);
        jokeView.setText(joke);

    }
}
