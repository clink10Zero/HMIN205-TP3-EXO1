package com.example.tp3_exo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final String KEY_CLE = "CLE";
    private int cle = 0;
    private Button validation;
    private Context context = this;

    public void setCleRand() {
        this.cle = (int)(Math.random()*1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.validation = (Button)findViewById(R.id.validation);

        this.validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCleRand();
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.cle = savedInstanceState.getInt(KEY_CLE);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CLE, cle);
    }
}