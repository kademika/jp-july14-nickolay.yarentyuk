package com.midgardabc.lesson_7Theory.task_7_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedListLauncher {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		names.add("B");
		names.add("E");
		names.add("A");
		names.add("G");
		names.add("C");
		names.add("H");
		names.add("D");
		names.add("F");
		
		Collections.sort(names);
		
		for (String name : names) {
			System.out.println(name);
		}
		
//		Collections.sort(names, new ZAComparator());
		
		Collections.sort(names, new Comparator<Object>() {	//	Anonimous class
			
			public int compare(Object o1, Object o2) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				
				int result = s1.compareToIgnoreCase(s2);
				if (result < 0) {
					return 1;
				} else if ( result > 0) {
					return -1;
				}
				return 0;
			};
		});
		
		System.out.println();
		for (String name : names) {
			System.out.println(name);
		}
		
		
	}
}
