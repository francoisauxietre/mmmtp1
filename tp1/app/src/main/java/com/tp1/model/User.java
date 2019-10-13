package com.tp1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String last_name;
    private String first_name;
    private String birth;
    private String phone_number;
    private int ratingbar;
    private int image;

    public User(String last_name, String first_name, String birth, String phone_number) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.birth = birth;
        this.phone_number = phone_number;
    }

    protected User(Parcel in) {
        last_name = in.readString();
        first_name = in.readString();
        birth = in.readString();
        phone_number = in.readString();

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