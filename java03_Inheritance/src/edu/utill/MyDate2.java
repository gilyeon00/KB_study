package edu.utill;

public class MyDate2 {
    private int year;
    private int month;
    private int day;

    public MyDate2(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate2() {
    }

    // Non-String + String ==> String
    public String getDate() {
        return year + ", " + month + ", " + day;
    }

}
