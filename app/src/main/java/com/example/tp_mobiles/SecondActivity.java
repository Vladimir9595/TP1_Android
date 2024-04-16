package com.example.tp_mobiles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    public static final String RESULT_PARAMETER = "Result";
    private TextView m_titleV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Bundle extras = getIntent().getExtras();
        String msg = extras.getString("title");

        m_titleV = findViewById(R.id.messageTv);
        m_titleV.setText(msg);
    }

    public void onClickYes(View view) {
        Log.v("SecondActivity", "onClick : YES button clicked");
        Intent returnIntent = new Intent();
        returnIntent.putExtra(RESULT_PARAMETER, "I am READY");
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    public void onClickNo(View view) {
        Log.v("SecondActivity", "onClick : NO button clicked");
        Intent returnIntent = new Intent();
        returnIntent.putExtra(RESULT_PARAMETER, "I am not READY");
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }
}