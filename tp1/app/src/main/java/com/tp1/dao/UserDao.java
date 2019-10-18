package com.tp1.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.tp1.model.User;

import java.util.List;

@Dao //defines the method that access the database, using annotation to bind SQL to each method.
// DAO data acces objects
// 4  @Query, @Insert, @Update, @Delete
public interface UserDao {
    @Query("SELECT * FROM user_table ")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM user_table WHERE user_id IN (:userIds)")
    LiveData<List<User>> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user_table WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")

    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Insert
    void insertList(List<User> list);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Delete
    void deleteAll(User... users);

}
