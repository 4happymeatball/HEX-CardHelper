package net.spinel.hexcards.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import net.spinel.hexcards.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.iv_card_query:
                intent = new Intent(this, CardQueryActivity.class);
                break;
            case R.id.iv_deck_build:
                intent = new Intent(this, DeckListActivity.class);
                break;
            case R.id.iv_draft_pick:
            case R.id.iv_card_diy:
                Toast.makeText(MainActivity.this, "progress", Toast.LENGTH_SHORT).show();
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    public void onSetting(View view) {
        Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();
    }
}
