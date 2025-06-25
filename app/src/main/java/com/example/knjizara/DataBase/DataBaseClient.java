package com.example.knjizara.DataBase;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class DataBaseClient {

        private static DataBaseClient instance;
        private RoomDataBase bookDatabase;

        private DataBaseClient(Context context) {
            bookDatabase = Room.databaseBuilder(context, RoomDataBase.class, "knjige_db")
                    .build();
        }

        public static DataBaseClient getInstance(Context context) {
            if (instance == null) {
                instance = new DataBaseClient(context);
            }
            return instance;
        }

        public RoomDataBase getDatabase() {
            return bookDatabase;
        }
    }

