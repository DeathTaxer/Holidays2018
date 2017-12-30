package com.clicsixdev.holidays2018;

/**
 * Created by aravind on 24-12-2017.
 */

import java.util.Calendar;


/**
 * Created by aravind on 17-12-2017.
 */

public class Holiday {
    private String name;
    private String mon;
    private String day;
    private String states;
    private Calendar date;

    private String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};



    public Holiday(String name, Calendar date, String states) {
        this.name = name;
        this.mon = months[date.get(Calendar.MONTH)] + " " + date.get(Calendar.DAY_OF_MONTH);
        this.day = days[date.get(Calendar.DAY_OF_WEEK) - 1];
        this.states = states;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getMon() {
        return mon;
    }

    public String getDay() {
        return day;
    }

    public String getStates() {
        return states;
    }

    public Calendar getDate() { return  date; }
}
