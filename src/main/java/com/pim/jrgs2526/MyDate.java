package com.pim.jrgs2526;

public class MyDate {

    public static final String ERR_INVALID_YEAR = "Year value not valid";
    public static final String ERR_INVALID_MONTH = "Month value not valid";
    public static final String ERR_INVALID_DAY = "Day value not valid";
    public static final String ERR_INVALID_DATE = "Invalid date";

    private int day;
    private Months month;
    private int year;

    public MyDate() {
        this.day = 1;
        this.month = Months.JANUARY;
        this.year = 2000;
    }

    public MyDate(int day, Months month, int year) {
        if (month == null || day < 1 || day > 31) {
            throw new IllegalArgumentException(ERR_INVALID_DATE);
        }

        this.day = day;
        this.month = month;
        this.year = year;

        if (day > daysInMonth(month, year)) {
            throw new IllegalArgumentException(ERR_INVALID_DATE);
        }
    }
    public int getDay() {
        return day;
    }

    public Months getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    public void setDay(int day) {
        if (day < 1 || day > daysInMonth(this.month, this.year)) {
            throw new IllegalArgumentException(ERR_INVALID_DAY);
        }

        this.day = day;
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
                (year % 4 == 0 && year % 100 != 0);
    }
    public void setMonth(Months month) {
        if (month == null || this.day > daysInMonth(month, this.year)) {
            throw new IllegalArgumentException(ERR_INVALID_MONTH);
        }

        this.month = month;
    }
    public void setYear(int year) {
        if (this.day > daysInMonth(this.month, year)) {
            throw new IllegalArgumentException(ERR_INVALID_YEAR);
        }

        this.year = year;
    }

    private int daysInMonth(Months month, int year) {
        switch (month) {
            case FEBRUARY:
                return isLeapYear(year) ? 29 : 28;

            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return 30;

            default:
                return 31;
        }
    }

    public enum Months {
        JANUARY(1),
        FEBRUARY(2),
        MARCH(3),
        APRIL(4),
        MAY(5),
        JUNE(6),
        JULY(7),
        AUGUST(8),
        SEPTEMBER(9),
        OCTOBER(10),
        NOVEMBER(11),
        DECEMBER(12);

        public final int monthNumber;

        private Months(int monthNumber) {
            this.monthNumber = monthNumber;
        }

        public static Months toMonth( int monthNumber ) {
            for (Months m : values())
                if (m.monthNumber == monthNumber)
                    return m;
            return null;
        }
    }
}
