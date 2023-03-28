package edu.utill;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    // Non-String + String ==> String
    public String getDate() {
        return year + ", " + month + ", " + day;
    }

}
