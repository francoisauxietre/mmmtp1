package com.tp1.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table") // Entity represents data for a single table row,
// constructed using an annotated java data object. Each entity is persisted into its own table.
public class User implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int user_id;

    @ColumnInfo(name = "last_name")
    private String last_name;

    @ColumnInfo(name = "first_name")
    private String first_name;

    @ColumnInfo(name = "birth")
    private String birth;

    @ColumnInfo(name = "phone_number")
    private String phone_number;

    @ColumnInfo(name = "town")
    private String town;

    @ColumnInfo(name = "department")
    private String department;

    private int ratingbar;
    private int image;


    public User(String last_name, String first_name, String birth, String phone_number, String town, String department) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.birth = birth;
        this.phone_number = phone_number;
        this.town = town;
        this.department = department;
    }

    protected User(Parcel in) {
        last_name = in.readString();
        first_name = in.readString();
        birth = in.readString();
        phone_number = in.readString();
        town = in.readString();
        department = in.readString();

    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(last_name);
        dest.writeString(first_name);
        dest.writeString(birth);
        dest.writeString(phone_number);
        dest.writeString(town);
        dest.writeString(department);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getRatingbar() {
        return ratingbar;
    }

    public void setRatingbar(int ratingbar) {
        this.ratingbar = ratingbar;
    }
}
