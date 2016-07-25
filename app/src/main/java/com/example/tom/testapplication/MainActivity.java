package com.example.tom.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tom.testapplication.cardview.CardViewFragment;
import com.example.tom.testapplication.viewgroupanimation.ViewGroupAnimationFragment;
import com.example.tom.testapplication.youtube.YouTubeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);

        setContentView(R.layout.activity_main);

        CardViewFragment fragment = (CardViewFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment == null) {
            fragment = new CardViewFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
        }

    }


}


