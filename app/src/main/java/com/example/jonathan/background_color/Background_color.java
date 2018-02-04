package com.example.jonathan.background_color;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Background_color extends AppCompatActivity {
    private View v;
    private TextView textView;

    private int counter = 0;
    private List<Integer> kleurenBackground = new ArrayList<>();
    private List<Integer> kleurenText = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_color);

        v = findViewById(R.id.winBackground);
        textView = findViewById(R.id.txtBackground);

        kleurenBackground.add(Color.YELLOW);
        kleurenBackground.add(Color.RED);
        kleurenBackground.add(Color.GREEN);
        kleurenBackground.add(Color.BLUE);
        kleurenText.add(Color.BLACK);
        kleurenText.add(Color.YELLOW);
        kleurenText.add(Color.MAGENTA);
        kleurenText.add(Color.WHITE);
        updateBackground();
    }

    @Override
    public void onContentChanged() {
        getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() { //1x
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                updateBackground();
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    counter++;
                    if (counter == 4)
                        counter = 0;
                }
                return true;
            }
        });
    }

    private void updateBackground() {
        textView.setTextColor(kleurenText.get(counter));
        getWindow().getDecorView().setBackgroundColor(kleurenBackground.get(counter));
    }
}




























// first attempt
               /* switch (counter) {
                    case 0:
                        textView.setTextColor(Color.BLACK);
                        getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                        counter++;
                        return true;
                    case 1:
                        textView.setTextColor(Color.YELLOW);
                        getWindow().getDecorView().setBackgroundColor(Color.RED);
                        counter++;
                        return true;
                    case 2:
                        textView.setTextColor(Color.MAGENTA);
                        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                        counter++;
                        return true;
                    case 3:
                        counter = 0;
                        textView.setTextColor(Color.WHITE);
                        getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                }*/