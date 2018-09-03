package com.tarangrien.tarangrien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btnConfig;
    private Button btnToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstance();
        setEvent();

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String s = sdf.format(d);
        Log.d("DateOfWeek",s);
    }

    private void setEvent() {
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ConfigRoomActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initInstance() {
        btnConfig = (Button) findViewById(R.id.btnConfig);
        btnToday = (Button) findViewById(R.id.btnToday);
    }
}
