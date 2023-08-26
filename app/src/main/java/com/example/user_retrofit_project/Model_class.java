package com.example.user_retrofit_project;

public class Model_class {
    String name;
    String username;
    String address;
    String lat;
    String phone;
    String bs;
    public Model_class(String name, String username, String address, String lat, String phone, String bs) {
        this.name = name;
        this.username = username;
        this.address = address;
        this.lat = lat;
        this.phone = phone;
        this.bs=bs;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "Model_class{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", lat='" + lat + '\'' +
                ", phone='" + phone + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
