package com.tp1.room;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.tp1.dao.UserDao;

import com.tp1.model.User;
//Database is a holder class that uses annotation to define the list of
// entities and database version. This class content defines the list of DAOs.


@Database(entities = {User.class}, version = 2)
public abstract class DataBase  extends RoomDatabase {

    private static DataBase instance;

    public abstract UserDao userDao();

    public static synchronized DataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DataBase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static User addUser(final DataBase db, User user) {
        db.userDao().insertAll(user);
        Log.i("Database", "add "+user.getFirst_name());
        return user;
    }


    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDao userDao;

        private PopulateDbAsyncTask(DataBase db) {
            userDao = db.userDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            User fa = new User("fa", "ox", "180972", "0002256", "rennes", "ille et vilaine");
            User fa1 = new User("fa", "ox", "180972", "0002256", "rennes", "ille et vilaine");

            addUser(instance, fa);
            addUser(instance, fa1);
//            userDao.insert(fa);
//            userDao.insert(fa1);


            return null;
        }
    }


    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }

}