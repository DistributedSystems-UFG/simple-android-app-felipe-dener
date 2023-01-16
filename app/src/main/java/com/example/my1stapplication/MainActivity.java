package com.example.my1stapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_SUBJECT = "com.example.my1stapplication.MESSAGE";
    public static final String EXTRA_MESSAGE = "com.example.my1stapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        Bundle extras = new Bundle();

        EditText editText1 = (EditText) findViewById(R.id.EditTextSubject);
        EditText editText2 = (EditText) findViewById(R.id.EditTextMessage);
        String subject = editText1.getText().toString();
        String message = editText2.getText().toString();

        extras.putString("EXTRA_SUBJECT", subject);
        extras.putString("EXTRA_MESSAGE", message);

        intent.putExtras(extras);
        startActivity(intent);
    }
}