package com.example.week3daily3homeassignment;

import com.example.week3daily3homeassignment.model.user.Dob;
import com.example.week3daily3homeassignment.model.user.Location;

public class ItemUser {

    private String name;
    private String smallImage;
    private String largeImage;
    private String gender;
    private String email;
    private String dob;
    private int age;
    private String phone;
    private String cell;
    private String nat;
    private String location;


    public ItemUser() {
    }

    public ItemUser(String name, String smallImage, String largeImage, String gender, String email, String dob, int age, String phone, String cell, String nat, String location) {
        this.name = name;
        this.smallImage = smallImage;
        this.largeImage = largeImage;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.phone = phone;
        this.cell = cell;
        this.nat = nat;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
