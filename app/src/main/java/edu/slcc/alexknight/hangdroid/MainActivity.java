package edu.slcc.alexknight.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public void startGame(View view)
    {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new_game) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startMultiplayerGame(View view) {
        Intent intent = new Intent(this, MultiplayerActivity.class);
        startActivity(intent);
    }

    public void openScores(View view) {
        Intent intent = new Intent(this, ScoresActivity.class);
        startActivity(intent);
    }

    public void startContactGame(View view) {
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

}
