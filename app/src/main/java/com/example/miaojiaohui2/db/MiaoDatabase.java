package com.example.miaojiaohui2.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CompanyEntity.class}, version = 1, exportSchema = false)
public abstract class MiaoDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "my_db";
    private static MiaoDatabase databaseInstance;

    public static synchronized MiaoDatabase getInstance(Context context)
    {
        if(databaseInstance == null)
        {
            databaseInstance = Room
                    .databaseBuilder(context.getApplicationContext(), MiaoDatabase.class, DATABASE_NAME)
                    .build();
        }
        return databaseInstance;
    }

    public abstract CompanyDao companyDao();
}
