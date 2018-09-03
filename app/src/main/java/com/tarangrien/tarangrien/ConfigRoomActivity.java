package com.tarangrien.tarangrien;

import android.os.AsyncTask;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;
import java.util.List;

public class ConfigRoomActivity extends AppCompatActivity {

    private Button btnComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_room);
        initInstance();

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        setEvent();

    }

    private void setEvent() {
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseInitializer.queryData(AppDatabase.getDatabase(getApplicationContext()));
            }
        });
    }


    private void initInstance() {
        btnComplete = (Button) findViewById(R.id.btnComplete);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(List<ClassRoom> classRoom) {
        Toast.makeText(getApplicationContext(), classRoom.get(1).getSubject(), Toast.LENGTH_SHORT).show();
        for (int i = 0; i < classRoom.size(); i++) {
            Log.d("classRoomQuery", "\n" + classRoom.get(i).getClassRoomId() + " : " + classRoom.get(i).getSubject());
        }
    }


}
