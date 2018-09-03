package com.tarangrien.tarangrien;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ClassRoomDao {

    @Query("SELECT * FROM ClassRoom")
    List<ClassRoom> getAll();

    @Query("SELECT COUNT(*) from ClassRoom")
    int countClassRoom();

    @Insert
    void insertAll(ClassRoom ... classRooms);

    @Delete
    void delete(ClassRoom classRooms);
}
