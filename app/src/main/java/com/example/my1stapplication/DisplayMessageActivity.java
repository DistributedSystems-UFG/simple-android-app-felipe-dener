package com.example.my1stapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    public static final String EXTRA_SUBJECT = "com.example.my1stapplication.MESSAGE";
    public static final String EXTRA_MESSAGE = "com.example.my1stapplication.MESSAGE";
    public static final String EXTRA_ADDRESS = "com.example.my1stapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String subject = extras.getString("EXTRA_SUBJECT");
        String message = extras.getString("EXTRA_MESSAGE");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.TextViewSubject);
        textView.setText(subject);

        TextView textView2 = findViewById(R.id.TextViewMessage);
        textView2.setText(message);

    }

    public void sendMail(View view){
        Intent intent = new Intent(this, SendMailActivity.class);
        Bundle extras = new Bundle();

        TextView Text1 = (TextView) findViewById(R.id.TextViewSubject);
        TextView Text2 = (TextView) findViewById(R.id.TextViewMessage);
        EditText Text3 = (EditText) findViewById(R.id.EditTextEmailAddress);
        String subject = Text1.getText().toString();
        String message = Text2.getText().toString();
        String address = Text3.getText().toString();

        extras.putString("EXTRA_SUBJECT",subject);
        extras.putString("EXTRA_MESSAGE",message);
        extras.putString("EXTRA_ADDRESS",address);

        intent.putExtras(extras);
        startActivity(intent);
    };
}