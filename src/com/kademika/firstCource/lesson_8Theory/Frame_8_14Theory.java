package com.midgardabc.lesson_8Theory;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Frame_8_14Theory {

	public static void main(String[] args) {
		
		Calendar c = new GregorianCalendar();
		
		c.set(Calendar.YEAR, 2012);
		c.set(Calendar.SECOND, 2);
		
		System.out.println(c.get(Calendar.SECOND));
		
		System.out.println(c.getTime());
		
		System.out.println(String.valueOf(c.getActualMaximum(Calendar.DAY_OF_MONTH)));
	}
}
