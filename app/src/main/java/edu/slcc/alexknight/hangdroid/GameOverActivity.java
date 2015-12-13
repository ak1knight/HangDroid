package edu.slcc.alexknight.hangdroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    int playerPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        playerPoints = getIntent().getIntExtra("PointsID",0);

        TextView textView = (TextView) findViewById(R.id.textViewPoints);
        textView.setText(String.valueOf(playerPoints));
    }

    public void saveScore(View view) {
        SharedPreferences preferences = getSharedPreferences("WORD_SCORES", Context.MODE_PRIVATE);

        EditText editText = (EditText) findViewById(R.id.editTextName);

        String name = editText.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();

        String previousScores = preferences.getString("SCORES", "");

        editor.putString("SCORES", name + " " + playerPoints + " POINTS\n" + previousScores);
        editor.commit();
    }
}
