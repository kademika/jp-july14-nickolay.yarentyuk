package com.midgardabc.lesson_6Homework.elMenu;

public class TaskHw_6_3Launcher {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		createMenu(menu);
		
		menu.fullprintMenu();
		
		menu.printMenuForPersonal();
		menu.desactivateDish(menu.getDish(9));
		menu.desactivateDish(menu.getDish(11));
		
		menu.shortprintMenu();
		
		menu.printMenuForPersonal();
		menu.deleteDish(menu.getDish(0));
		
		menu.fullprintMenu();
		
		addToMenu(menu);
		menu.printMenuForPersonal();
		menu.activateDish(menu.getDish(8));
		menu.activateDish(menu.getDish(10));
		
		menu.fullprintMenu();
		
//		menu.activateDish(menu.getDish(0));
//		
//		menu.printMenuForPersonal();
	}
	
	public static void createMenu(Menu menu) {
		
		menu.addDish(new Dish("Black coffee", new Product[] {
				new Product("Water", 100, Unit.MILLILITER),
				new Product("Coffee", 10, Unit.GRAM),
				new Product("Sugar", 30, Unit.GRAM)},
				10.50, true));
		
		menu.addDish(new Dish("Coffee with cream", new Product[] {
				new Product("Water", 100, Unit.MILLILITER),
				new Product("Coffee", 10, Unit.GRAM),
				new Product("Cream", 20, Unit.MILLILITER),
				new Product("Sugar", 30, Unit.GRAM)},
				15.00, true));
		
		menu.addDish(new Dish("Black tea", new Product[] {
				new Product("Water", 100, Unit.MILLILITER),
				new Product("Black tea", 5, Unit.GRAM)},
				5.00, true));
		
		menu.addDish(new Dish("Black tea with sugar", new Product[] {
				new Product("Water", 100, Unit.MILLILITER),
				new Product("Black tea", 5, Unit.GRAM),
				new Product("Sugar", 30, Unit.GRAM)},
				6.00, true));
		
		menu.addDish(new Dish("Green tea", new Product[] {
				new Product("Water", 100, Unit.MILLILITER),
				new Product("Green tea", 5, Unit.GRAM)},
				10.00, true));
		
		menu.addDish(new Dish("Green tea with sugar", new Product[] {
				new Product("Water", 100, Unit.MILLILITER),
				new Product("Green tea", 5, Unit.GRAM),
				new Product("Sugar", 30, Unit.GRAM)},
				12.00, true));
		
		menu.addDish(new Dish("Tea Carcade", new Product[] {
				new Product("Water", 100, Unit.MILLILITER),
				new Product("Tea Carcade", 5, Unit.GRAM)},
				15.00, true));
		
		menu.addDish(new Dish("Tea Carcade with sugar", new Product[] {
				new Product("Water", 100, Unit.MILLILITER),
				new Product("Tea Carcade", 5, Unit.GRAM),
				new Product("Sugar", 30, Unit.GRAM)},
				17.00, true));
		
		menu.addDish(new Dish("CocaCola", new Product[] {
				new Product("Coca Cola", 0.5, Unit.LITER)},
				5.00, true));
		
		menu.addDish(new Dish("CocaCola with ice", new Product[] {
				new Product("Coca Cola", 0.5, Unit.LITER),
				new Product("Ice", 50, Unit.GRAM)},
				5.50, true));
		
		menu.addDish(new Dish("Pepsi", new Product[] {
				new Product("Pepsi", 0.5, Unit.LITER)},
				7.00, true));
		
		menu.addDish(new Dish("Pepsi with ice", new Product[] {
				new Product("Pepsi", 0.5, Unit.LITER),
				new Product("Ice", 50, Unit.GRAM)},
				7.50, true));
	}
	
	public static void addToMenu(Menu menu) {
		
		menu.addDish(new Dish("Sprite", new Product[] {
				new Product("Sprite", 0.5, Unit.LITER)},
				6.00, true));
		menu.addDish(new Dish("Sprite with ice", new Product[] {
				new Product("Sprite", 0.5, Unit.LITER),
				new Product("Ice", 50, Unit.GRAM)},
				6.50, true));
		menu.addDish(new Dish("Fanta", new Product[] {
				new Product("Fanta", 0.5, Unit.LITER)},
				6.50, true));
		menu.addDish(new Dish("Fanta with ice", new Product[] {
				new Product("Fanta", 0.5, Unit.LITER),
				new Product("Ice", 50, Unit.GRAM)},
				7.00, true));
		menu.addDish(new Dish("7Up", new Product[] {
				new Product("7Up", 0.5, Unit.LITER)},
				3.00, true));
		menu.addDish(new Dish("7Up with ice", new Product[] {
				new Product("7Up", 0.5, Unit.LITER),
				new Product("Ice", 50, Unit.GRAM)},
				3.50, true));
	}
}
