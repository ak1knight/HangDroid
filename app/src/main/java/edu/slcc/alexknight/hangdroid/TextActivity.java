package edu.slcc.alexknight.hangdroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextActivity extends AppCompatActivity {

    private EditText editText;
    private SharedPreferences preferences;
    private TextView textView;
    private String textWord;
    private String friendPhone;
    private String texterPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        preferences = getSharedPreferences("TEXT_MSGS", MODE_PRIVATE);

        friendPhone = getIntent().getStringExtra("Phone");

        getTextFromPref();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multiplayer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_main_menu:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setTextMessage(View view) {
        getTextFromPref();
    }

    public void getTextFromPref() {
        textWord = preferences.getString("TextedWord", "NO WORD");
        texterPhone = preferences.getString("TexterPhone", "NO PHONE");
        textView = (TextView) findViewById(R.id.editTextWord);

        if (textWord == "NO WORD" && friendPhone.equals(texterPhone)) {
            textView.setText(textWord);
            textWord = "";
            texterPhone = "";
        } else {
            Toast.makeText(this, "No Text Received from Selected Friend", Toast.LENGTH_LONG).show();
        }

        Log.d("MYLOG", "Texted Word: " + textWord);
    }

    public void playMultiplayerGame(View view) {
        String textWord = textView.getText().toString();
        if (textWord.length() > 0) {
            textView.setText("");

            preferences.edit().remove("TextedWord").apply();
            Log.d("MYLOG", "Multi-Player Word: " + textWord);

            Intent intent = new Intent(this, GameMultiActivity.class);

            intent.putExtra("GuessID", textWord);
            startActivity(intent);

        } else {
            Snackbar.make(view, "No Word Found - Try GET NEW TEXT", Snackbar.LENGTH_LONG).show();
        }
    }

}
