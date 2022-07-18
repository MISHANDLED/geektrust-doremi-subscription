package com.example.geektrust;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateCheck {
	
	public boolean dateChecker(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.setLenient(false);

        try {
            format.parse(date);
        } catch (ParseException e) {
            return false;
        }
		return true;
	}

}
