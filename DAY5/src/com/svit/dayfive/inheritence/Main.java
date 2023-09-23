package com.svit.dayfive.inheritence;

public class Main {
	
	public static void main(String[] args) {
		// create an object of the subclass
	    Dog labrador = new Dog();

	    // access field of superclass
	    labrador.name = "Bala Sai";
	    labrador.display();

	    // call method of superclass
	    // using object of subclass
	    labrador.eat();
	}

}
