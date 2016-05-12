package net.spinel.hexcards.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import net.spinel.hexcards.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageLoader.getInstance().displayImage("assets://alpha_001.jpg", (ImageView) findViewById(R.id.imageView));
    }
}
