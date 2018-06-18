package com.pollaktamas.datesandstringsandlocalization.localization;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Tax_hu_HU extends ListResourceBundle {
    protected Object[][] getContents() {
        return new Object[][]{{"tax", new Integer(100)}};
    }

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle(
                "com.pollaktamas.datesandstringsandlocalization.localization.Tax", new Locale("hu", "HU"));
        System.out.println(rb.getObject("tax"));
    }
}
