package co.khanal.libjokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplay extends AppCompatActivity {

    public static final String JOKE_KEY = "joke_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        String joke = getIntent().getStringExtra(JOKE_KEY);
        if(joke == null)
            throw new IllegalArgumentException("Cannot have this activity without a joke in the intent.");

        ((TextView) findViewById(R.id.joke_text_view)).setText(joke);
    }
}
