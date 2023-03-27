package com.edu.utill;

public class MyDate3 {
    private int year;
    private int month;
    private int day;

    public MyDate3(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate3() {
    }

    @Override
    public String toString() {
        return year +  " " + month + " " + day;
    }
}
