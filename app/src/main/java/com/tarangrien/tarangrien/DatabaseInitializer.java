package com.tarangrien.tarangrien;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class DatabaseInitializer {
    private static final String TAG = DatabaseInitializer.class.getName();

    private static final int QUERY = 1;
    private static final int INSERT = 2;

    public static void insertData(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db, INSERT);
        task.execute();
    }

    public static void queryData(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db, QUERY);
        task.execute();
    }

    private static void populateQueryTestData(AppDatabase db) {
        List<ClassRoom> userList = db.classRoomDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.get(1).getSubject());
        EventBus myEventBus = EventBus.getDefault();
        EventBus.getDefault().post(userList);
    }

    private static ClassRoom addUser(final AppDatabase db, ClassRoom classRoom) {
        db.classRoomDao().insertAll(classRoom);
        return classRoom;
    }
    private static void populateWithTestData(AppDatabase db) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setDay("Monday");
        classRoom.setTimeStart("9.25");
        classRoom.setSubject("MakeUp");
        classRoom.setNumberOfRoom("401");
        addUser(db, classRoom);

        List<ClassRoom> userList = db.classRoomDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.get(1).getSubject());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;
        private int type;

        PopulateDbAsync(AppDatabase db, int type) {
            mDb = db;
            this.type = type;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            if (type == QUERY) {
                populateQueryTestData(mDb);
            } else if (type == INSERT)
                populateWithTestData(mDb);
            return null;
        }

    }
}
