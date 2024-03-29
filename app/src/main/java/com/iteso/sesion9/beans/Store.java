package com.iteso.sesion9.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Store implements Parcelable {
    private	int	id;
    private	String name;
    private	String phone;
    private	int	thumbnail;
    private	double latitude;
    private	double longitude;
    private	City city;

    public Store() {
    }

    public Store(int id, String name, String phone, int thumbnail, double latitude, double longitude, City city) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.thumbnail = thumbnail;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name + "," + city.getName().toUpperCase();
    }

    protected Store(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.phone = in.readString();
        this.thumbnail = in.readInt();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.city = in.readParcelable(City.class.getClassLoader());
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeInt(this.thumbnail);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeParcelable(this.city, flags);

    }
}

