package com.midgardabc.lesson_4Theory;

public class Task_4_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reference ref1 = new Reference("ref1");
		Reference ref2 = new Reference("ref2");
		Reference ref3 = new Reference("ref3");
		
		ref1.setRef(ref2);
		ref2.setRef(ref3);
		ref3.setRef(ref1);
		
		ref1.printRef();
		ref2.printRef();
		ref3.printRef();
	}

}
