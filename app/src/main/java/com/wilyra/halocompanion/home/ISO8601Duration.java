package com.wilyra.halocompanion.home;

/**
 * Created by wilyr on 11/23/2015.
 */
public class ISO8601Duration {
    int days;
    int hours;

    public int getMinutes() {
        return minutes;
    }

    public int getDays() {
        return days;
    }

    public int getHours() {
        return hours;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    int minutes;
    int seconds;
    int milliseconds;

    public ISO8601Duration(String duration) {
        try {
            if (duration != null) {
                int i = 0;
                while (duration.charAt(i) == 'P' || duration.charAt(i) == 'T')
                    i++;
                while (i < duration.length()) {
                    while (i < duration.length() && (duration.charAt(i) == 'P' || duration.charAt(i) == 'T'))
                        i++;
                    if (i >= duration.length())
                        break;
                    String tmp = "";
                    while (duration.charAt(i) != 'M' &&
                            duration.charAt(i) != 'S' &&
                            duration.charAt(i) != 'D' &&
                            duration.charAt(i) != 'H' &&
                            i < duration.length()) {
                        tmp += duration.charAt(i);
                        i++;
                    }
                    if (i >= duration.length())
                        break;
                    switch (duration.charAt(i)) {
                        case 'D':
                            days = Integer.parseInt(tmp);
                            break;
                        case 'H':
                            hours = Integer.parseInt(tmp);
                            break;
                        case 'M':
                            minutes = Integer.parseInt(tmp);
                            break;
                        case 'S':
                            seconds = (int) Float.parseFloat(tmp);
                            break;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString()
    {
        String out = "";
        if (days != 0)
            out += String.valueOf(days) + "D ";
        if ((days != 0 && hours == 0) || hours != 0)
            out += String.valueOf(hours) + "H ";
        if (((days != 0 || hours != 0) && minutes == 0) || minutes != 0)
            out += String.valueOf(minutes) + "M ";
        if (((days != 0 || hours != 0 || minutes != 0) && seconds == 0) || seconds != 0)
            out += String.valueOf(seconds) + "S ";
        return (out);
    }

    public void addDuration(ISO8601Duration dur)
    {
        this.days += dur.getDays();
        this.hours += dur.getHours();
        this.minutes += dur.getMinutes();
        this.seconds += dur.getSeconds();
    }
}
