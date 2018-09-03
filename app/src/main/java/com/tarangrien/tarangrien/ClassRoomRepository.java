package com.tarangrien.tarangrien;

import android.arch.lifecycle.LiveData;

import java.util.List;

public class ClassRoomRepository {
    private ClassRoomDao mWordDao;
    private LiveData<List<ClassRoom>> mAllWords;

}
