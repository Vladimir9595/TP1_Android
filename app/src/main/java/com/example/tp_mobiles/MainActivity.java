package com.example.tp_mobiles;

import static com.example.tp_mobiles.SecondActivity.RESULT_PARAMETER;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 0;
    private TextView m_resulTv;
    private View m_openActivityLayout;
    private TextView m_resultFromActivity;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_resulTv = findViewById(R.id.result);
        m_openActivityLayout = findViewById(R.id.openActivityLayout);
        m_resultFromActivity = findViewById(R.id.resultFromActivity);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "It is the first activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @SuppressLint("SetTextI18n")
    public void onAddClick(View v){
        Log.d("Main Activity", "Button ADD clicked");
        String resultStr = m_resulTv.getText().toString();
        int result = Integer.parseInt(resultStr);
        result ++;
        m_resulTv.setText(Integer.toString(result));
    }

    public void onSubClick(View v){
        Log.d("Main Activity", "Button SUB clicked");
        String resultStr = m_resulTv.getText().toString();
        int result = Integer.parseInt(resultStr);
        result --;
        m_resulTv.setText(String.valueOf(result));
    }

    public void onShowToastClick(View v){
        Log.d("Main Activity", "Button SHOW TOAST clicked");
        Toast.makeText(this, "Voici mon Toast", Toast.LENGTH_LONG).show();
    }

    // Le snack peut être customisé
    public void onShowSnackBarClick(View v){
        Log.d("Main Activity", "Button SNACK clicked");
        Snackbar.make(v, "Mon Snack !!", Snackbar.LENGTH_LONG).show();
    }

    public void onOpenActivityClicked(View v){
        Log.d("Main Activity", "Button FIRST ACTIVITY clicked");
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }

    public void onOpenActivityTwoClicked(View v){
        Log.d("Main Activity", "Button SECOND ACTIVITY clicked");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("title", "Are you ready ?");
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            // Get the onClickYes in SecondActivity
            m_openActivityLayout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
        } else {
            m_openActivityLayout.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        }
        if (data != null) {
            String result = data.getStringExtra(RESULT_PARAMETER);
            m_resultFromActivity.setText(result);
        }
    }
}