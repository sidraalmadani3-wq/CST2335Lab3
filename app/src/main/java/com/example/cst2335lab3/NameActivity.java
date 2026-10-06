package com.example.cst2335lab3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class NameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        Button dontCallButton = findViewById(R.id.dontCallButton);
        Button thankYouButton = findViewById(R.id.thankYouButton);

        String name = getIntent().getStringExtra("name");
        welcomeTextView.setText(getString(R.string.welcome_name, name));

        dontCallButton.setOnClickListener(v -> {
            setResult(0);
            finish();
        });

        thankYouButton.setOnClickListener(v -> {
            setResult(1);
            finish();
        });
    }
}
