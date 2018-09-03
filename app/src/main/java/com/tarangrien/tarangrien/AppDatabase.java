package com.tarangrien.tarangrien;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.provider.SyncStateContract;

@Database(entities = { ClassRoom.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ClassRoomDao classRoomDao();
    private static AppDatabase INSTANCE;

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "ClassRoom")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
