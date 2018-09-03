package com.tarangrien.tarangrien;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "ClassRoom")
public class ClassRoom {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int  classRoomId;

    @ColumnInfo(name = "day")
    private String day;

    @ColumnInfo(name = "time_start")
    private String timeStart;

    @ColumnInfo(name = "subject")
    private String subject;

    @ColumnInfo(name = "number_of_room")
    private String numberOfRoom;

    public ClassRoom() {
    }

    @NonNull
    public int getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(@NonNull int classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(String numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public ClassRoom(@NonNull int classRoomId, String day, String timeStart, String subject, String numberOfRoom) {
        this.classRoomId = classRoomId;
        this.day = day;
        this.timeStart = timeStart;
        this.subject = subject;
        this.numberOfRoom = numberOfRoom;
    }
}
