package com.serviceexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start, btn_stop;
    private EditText enter_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter_text= (EditText) findViewById(R.id.enter_text);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // Method to start the service
            case R.id.btn_start:
                Intent intent = new Intent(getBaseContext(), MyService.class);
                startService(intent);
                break;
            // Method to stop the service
            case R.id.btn_stop:
                stopService(new Intent(getBaseContext(), MyService.class));
                break;
        }
    }
}
