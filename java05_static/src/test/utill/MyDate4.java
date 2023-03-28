package test.utill;

public class MyDate4 {
    private int year;
    private int month;
    private int day;

    public MyDate4(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate4() {
    }

    @Override
    public String toString() {
        return year +  " " + month + " " + day;
    }
}
