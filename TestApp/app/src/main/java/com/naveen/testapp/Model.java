package com.naveen.testapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Model implements Parcelable {


    private String userName;
    private String password;

    @Override
    public String toString() {
        return "Model{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public final static Parcelable.Creator<Model> CREATOR = new Creator<Model>() {


        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        public Model[] newArray(int size) {
            return (new Model[size]);
        }

    };

    protected Model(Parcel in) {
        this.userName = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Model() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userName);
        dest.writeValue(password);
    }

    public int describeContents() {
        return 0;
    }

}