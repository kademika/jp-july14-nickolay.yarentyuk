package com.midgardabc.lesson_8Theory;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Frame_8_14 {

	public static void main(String[] args) {
		
		Calendar c = new GregorianCalendar(1988, Calendar.DECEMBER, 5);
		
//		c.set(Calendar.YEAR, 1988);
//		c.set(Calendar.MONTH, 12);
//		c.set(Calendar.DAY_OF_MONTH, 19);
		
//		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		
        System.out.println(c.getDisplayName(Calendar.DAY_OF_WEEK, 2, java.util.Locale.ENGLISH));
        System.out.println(c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
        
        
	}
}
