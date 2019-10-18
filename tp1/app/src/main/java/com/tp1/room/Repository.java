package com.tp1.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.tp1.dao.UserDao;
import com.tp1.model.User;

import java.util.List;

public class Repository {
    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public Repository(Application application) {
        DataBase database = DataBase.getInstance(application);
        userDao = database.userDao();
        allUsers = userDao.getAll();
    }

    public void insert(User note) {
        new InsertUserAsyncTask(userDao).execute(note);
    }


    public void delete(User note) {
        new DeleteUserAsyncTask(userDao).execute(note);
    }

    public void deleteAllUsers() {
        new DeleteAllUsersAsyncTask(userDao).execute();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        private InsertUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }


    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        private DeleteUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.delete(users[0]);
            return null;
        }
    }

    private static class DeleteAllUsersAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDao noteDao;

        private DeleteAllUsersAsyncTask(UserDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAll();
            return null;
        }
    }
}
