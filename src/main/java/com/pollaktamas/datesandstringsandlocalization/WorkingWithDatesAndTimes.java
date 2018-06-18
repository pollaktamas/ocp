package com.pollaktamas.datesandstringsandlocalization;

import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class WorkingWithDatesAndTimes {

    public static void main(String[] args) {
        System.out.println(ZoneId.systemDefault());

        Locale locale = new Locale.Builder().setLanguage("MYLAN").setRegion("ne").build();
        System.out.println(locale);
        ResourceBundle resourceBundle = null;
        resourceBundle.getObject("a");
    }
}
