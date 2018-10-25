package com.mohamed14riad.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    private TextView jokeText = null;
    private String joke = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        jokeText = findViewById(R.id.joke_text_view);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra(AppConstants.JOKE_KEY)) {
            joke = intent.getStringExtra(AppConstants.JOKE_KEY);

            if (joke != null && !joke.isEmpty()) {
                jokeText.setText(joke);
            } else {
                jokeText.setText("No Jokes Found!");
            }
        } else {
            jokeText.setText("No Jokes Passed!");
        }
    }
}
