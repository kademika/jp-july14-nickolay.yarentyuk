package com.midgardabc.lesson_6Homework.elMenu;

public class Menu {
	
	private Dish[] dishes;
	
	private int maxValue;
	
	public Menu() {
		
		dishes = new Dish[100];
		maxValue = -1;
	}
	
	public void addDish(Dish newDish) {
		
//		int number;
		
		if (dishes[dishes.length - 1] != null) {
			Dish[] t = dishes;
			dishes = new Dish[t.length + 10];
			System.arraycopy(t, 0, dishes, 0, t.length);
		}
		
		dishes[++maxValue] = newDish;
	}
	
	public void deleteDish(Dish dish) {
		
		if (dish != dishes[maxValue]) {
			for (int i = 0; i < maxValue; i++) {
				if (dishes[i] == dish) {
					for (int j = i; j < maxValue; j++) {
						dishes[j] = dishes[j + 1];
					}
					break;
				}
			}
			dishes[maxValue] = null;
		}
		
		maxValue--;
	}
	
	public void shortprintMenu() {
		
		System.out.println();
		if (maxValue == -1) {
			System.out.println("Menu is empty.");
		} else {
			System.out.println("Menu:");
			
			for (int i = 0; i <= maxValue; i++) {
				if (dishes[i].isPresent()) {
					System.out.println();
					System.out.println(dishes[i].getName() + ":");
					System.out.println(dishes[i].getPrice() + " grn.");
				}
			}
		}
	}
	
	public void fullprintMenu() {
		
		System.out.println();
		if (maxValue == -1) {
			System.out.println("Menu is empty.");
		} else {
			System.out.println("Menu:");
			
			for (int i = 0; i <= maxValue; i++) {
				if (dishes[i].isPresent()) {
					System.out.println();
					System.out.println(dishes[i].getName() + ":");
					
					Product[] products = dishes[i].getProducts();
					System.out.print("(");
					for (int j = 0; j < products.length - 1; j++) {
						System.out.print(products[j].getName() + ": " + products[j].getTotal() + " " +
								products[j].getUnit() + ", ");
					}
					System.out.println(products[products.length - 1].getName() + ": " +
							products[products.length - 1].getTotal() + " " + products[products.length - 1].getUnit() + ")");
					System.out.println(dishes[i].getPrice() + " grn.");
				}
			}
		}
	}
	
	public void printMenuForPersonal () {
		
		System.out.println();
		if (maxValue == -1) {
			System.out.println("Menu is empty.");
		} else {
			System.out.println("Menu:");
			
			for (int i = 0; i <= maxValue; i++) {
				System.out.println();
				System.out.println(i + ". " + dishes[i].getName() + ":");
				
				Product[] products = dishes[i].getProducts();
				System.out.print("(");
				for (int j = 0; j < products.length - 1; j++) {
					System.out.print(products[j].getName() + ": " + products[j].getTotal() + " " +
							products[j].getUnit() + ", ");
				}
				System.out.println(products[products.length - 1].getName() + ": " +
						products[products.length - 1].getTotal() + " " + products[products.length - 1].getUnit() + ")");
				System.out.println(dishes[i].getPrice() + " grn.");
				if (dishes[i].isPresent()) {
					System.out.println("(Present)");
				} else {
					System.out.println("(Absent)");
				}
			}
		}
	}
	
	public void activateDish(Dish dish) {
		dish.setPresent(true);
	}
	
	public void desactivateDish(Dish dish) {
		dish.setPresent(false);
	}
	
	public Dish getDish(int n) {
		return dishes[n];
	}
}
