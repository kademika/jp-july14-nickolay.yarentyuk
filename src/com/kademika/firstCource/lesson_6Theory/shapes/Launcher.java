package com.midgardabc.lesson_6Theory.shapes;


public class Launcher {

	public static void main(String[] args) {
		
		Drawable[] shapes = new Drawable[] {
				
				new Circle(50, 50, 100, 100, 10),
				new Rectangle(200, 50, 150, 100, 10),
				new Triangle(50, 200, 100, 100, 10),
				new Square(225, 200, 100, 10)
		};
		
		new ShapesTemplate(shapes);
	}

}
