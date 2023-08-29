package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean onOff = false;
    Button button;
    private Flashlight flashlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        flashlight =new Flashlight(this);

        button.setOnClickListener(v -> {
            if(onOff){
                button.setText(getString(R.string.off));
                flashlight.turnOffFlashlight();
                onOff = false;
            } else {
                button.setText("ON");
                onOff = true;
                flashlight.turnOnFlashlight();
            }

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        flashlight.turnOffFlashlight();
        finish();
    }


    @Override
    protected void onPause() {
        super.onPause();
        if(onOff){
            onOff = false;
            flashlight.turnOffFlashlight();
            button.setText(getString(R.string.off));
        }
    }
}