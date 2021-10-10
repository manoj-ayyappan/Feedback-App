package com.example.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    RadioGroup rgFeedback;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        rgFeedback = findViewById(R.id.rgFeedback);
        btnShare = findViewById(R.id.btnShare);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.length() == 0) {
                    etName.setError("Name is empty");
                    return;
                }

                int id = rgFeedback.getCheckedRadioButtonId();
                RadioButton rb = findViewById(id);
                String feedback = rb.getText().toString();

                String msg = "Name = " + etName.getText() + "\nFeedback = " + feedback;
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                Intent a = new Intent(Intent.ACTION_SEND);
                a.putExtra(Intent.EXTRA_TEXT, msg);
                a.setType("text/plain");
                startActivity(a);
            }
        });
    }
}