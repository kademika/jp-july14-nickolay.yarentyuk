package com.midgardabc.lesson_2Theory;

public class Task_2_12 {

public static void main(String[] args) {
		
		String x = "c";
		String y = "2";
		
		PrintCordinates(x, y);
	}

	static void PrintCordinates(String v, String g) {
		
		String quadrant = getQuadrant(v, g);
		int divider = quadrant.indexOf('_');
		
		System.out.println(v + g + '(' + quadrant.substring(0, divider) + "px;" + quadrant.substring(divider + 1) + "px)"); // a2:(0px;64px)
	}
	
	static String getQuadrant(String v, String h) { // 1
		/**
		 * Возврвщает координату леого верхнего угла квадрата в пикселах
		 * 
		 * @param v - "a"-"i"
		 * @param h - "1"-"9"
		 * @return result = "<координата h>"_"<координата v>"
		 */
		
		String result; // Результат
		
		if (v == "a")
			result = "0";
			else
				if (v == "b")
					result = "64";
					else
						if (v == "c")
							result = "128";
							else
								if (v == "d")
									result = "192";
									else
										if (v == "e")
											result = "256";
											else
												if (v == "f")
													result = "320";
													else
														if (v == "g")
															result = "384";
															else
																if (v == "h")
																	result = "448";
																	else
																		result = "512"; //	if (v == "i")																	
		
		result = result + "_";
		
		if (h == "1")
			result = result + "0";
			else
				if (h == "2")
					result = result + "64";
					else
						if (h == "3")
							result = result + "128";
							else
								if (h == "4")
									result = result + "192";
									else
										if (h == "5")
											result = result + "256";
											else
												if (h == "6")
													result = result + "320";
													else
														if (h == "7")
															result = result + "384";
															else
																if (h == "8")
																	result = result + "448";
																	else
																		result = result + "512"; // if (h == "9")
		
		return result;
	}
	
}
