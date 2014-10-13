package com.midgardabc.lesson_7Theory.task_7_10;

import java.util.Comparator;

public class ZAComparator implements Comparator<String> {
	
	@Override
	public int compare(String o1, String o2) {
		int result = o1.compareToIgnoreCase(o2);
		if (result < 0) {
			return 1;
		} else if ( result > 0) {
			return -1;
		}
		return 0;
	}
}
