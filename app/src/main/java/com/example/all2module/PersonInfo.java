package com.example.all2module;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonInfo implements Parcelable {
    private String name;
    private String surname;

    // Constructor
    public PersonInfo(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    // Parcelling part
    public PersonInfo(Parcel in){
        String[] data = new String[2];

        in.readStringArray(data);
        // the order needs to be the same as in writeToParcel() method
        this.name = data[0];
        this.surname = data[1];
    }

    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
    }
    public static final Parcelable.Creator CREATOR = new Creator<PersonInfo>() {
        public PersonInfo createFromParcel(Parcel in) {
            return new PersonInfo(in);
        }

        public PersonInfo[] newArray(int size) {
            return new PersonInfo[size];
        }
    };
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
}