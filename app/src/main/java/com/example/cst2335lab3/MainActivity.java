package com.example.cst2335lab3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText nameEditText;
    private SharedPreferences preferences;
    private final int NAME_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        Button nextButton = findViewById(R.id.nextButton);
        preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);

        String savedName = preferences.getString("name", "");
        if (!savedName.isEmpty()) {
            nameEditText.setText(savedName);
        }

        nextButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            intent.putExtra("name", name);
            startActivityForResult(intent, NAME_REQUEST);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        preferences.edit().putString("name", nameEditText.getText().toString()).apply();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NAME_REQUEST) {
            if (resultCode == 0) {
                nameEditText.requestFocus();
                nameEditText.selectAll();
            } else if (resultCode == 1) {
                finish();
            }
        }
    }
}
