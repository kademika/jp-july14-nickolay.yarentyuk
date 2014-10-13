package com.midgardabc.lesson_8Theory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Frame_8_13 {

	public static void main(String[] args) throws Exception {
		
		Date today = new Date();
		System.out.println(today);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
		System.out.println(sdf.format(today));
		Date date = sdf.parse("05 Dec 1988");
		System.out.println(sdf.format(date));
		
		System.out.println();
		
		sdf = new SimpleDateFormat("dd MMM yyyy");
		System.out.println(sdf.format(today));
		date = sdf.parse("05 дек 1988");
		System.out.println(sdf.format(date));
		
//		testDate();
//		testCalendar();
	}
	
	static void testDate() throws Exception {
		Date today = new Date();
		System.out.println(today);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
		System.out.println(sdf.format(today));
		
		Date birthday = sdf.parse("05 Feb 1985");
		System.out.println(sdf.format(birthday));
	}

	static void testCalendar() throws Exception {
		Calendar c = new GregorianCalendar(Locale.ENGLISH);
//		c.set(Calendar.MINUTE, 0);
//		c.set(Calendar.SECOND, 0);
		
		System.out.println(c.getTime());
		System.out.println(String.valueOf(c.getMaximum(Calendar.DAY_OF_MONTH)));
		
		Calendar c1 = new GregorianCalendar(1985, 2, 5);
		System.out.println(c1.getDisplayName(c1.DAY_OF_WEEK, c1.LONG, Locale.getDefault()));
	}
}
