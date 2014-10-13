package com.midgardabc.lesson_2Theory;

public class Task_2_11_Tanks_1 {

	public static void main(String[] args) {

		String x = "c";
		String y = "9";
		
		System.out.println(getQuadrantXY(x, y));
	}

	/**
	 * - TANKS -
	 */
	
	static String getQuadrantXY(String v, String h) { // 1
		/**
		 * ¬озврвщает координату леого верхнего угла квадрата в пикселах
		 * 
		 * @param v - "a"-"i"
		 * @param h - "1"-"9"
		 * @return result = "<координата h>"_"<координата v>"
		 */
		
		int x = Integer.valueOf(h);
		int y;
		
		if (v.equals("a"))
			y = 1;
		else if (v.equals("b"))
			y = 2;
		else if (v.equals("c"))
			y = 3;
		else if (v.equals("d"))
			y = 4;
		else if (v.equals("e"))
			y = 5;
		else if (v.equals("f"))
			y = 6;
		else if (v.equals("g"))
			y = 7;
		else if (v.equals("h"))
			y = 8;
		else
			y = 9;
		
		return String.valueOf((y - 1) * 64) + "_" + String.valueOf((x - 1) * 64);
	}
	
}
