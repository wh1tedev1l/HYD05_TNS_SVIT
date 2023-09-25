package home;

import java.util.Scanner;

import application.Admin;
import application.Billing;
import application.Cart;
import application.Reports;

public class Dashboard {
	public static void mainMenu() {
		System.out.println("+--------------------+");
		System.out.println("| Welcome to the POS |");
		System.out.println("+--------------------+\n");
		System.out.println("1.Billing\n2.Admin\n3.Report\n0.Exit\n");
		System.out.print("\nEnter your Option: ");
		
		Scanner sc= new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			billingMenu();
		case 2:
			adminMenu();
		case 3:
			reportMenu();
		case 0:
			sc.close();
			System.exit(0);
		default:
			System.out.println("Wrong Input");
			mainMenu();
		}	
	}
	
	public static void main(String args[]) {
		mainMenu();
	}
	
	public static void billingMenu() {
		
		Billing billingScreen = new Billing();
		Cart cart = new Cart();
		int itemChoice;
		int itemQuantity;
		
		Scanner sc= new Scanner(System.in);

		System.out.println("+---------+");
		System.out.println("| Billing |");
		System.out.println("+---------+\n");
		System.out.println("1.Add Items to Cart\n2.Remove Item from Cart\n3.Proceed Checkout\n\n9.Main Menu\n0.Exit\n");
		System.out.print("\nEnter your Option: ");
		int choice = sc.nextInt();

		switch(choice) {
		case 1:
			billingScreen.displayItems();
			System.out.print("\n99.Billing Menu\n0.Exit\n\nEnter your Option: ");
			itemChoice = sc.nextInt();
			System.out.print("\nEnter Quantity: ");
			itemQuantity = sc.nextInt();
			cart.addItem(itemChoice, itemQuantity);
			if(itemChoice == 9) {billingMenu();}
			cart.displayItems();
			billingMenu();
		case 2:
			cart.displayItems();
			System.out.print("\nSelect Item: ");
			itemChoice = sc.nextInt();
			cart.removeItem(itemChoice);
			cart.displayItems();
			billingMenu();
		case 3:
			cart.proceed();
			billingMenu();
		case 9:
			mainMenu();
		case 0:
			sc.close();
			System.exit(0);
		default:
			System.out.println("Wrong Input");
			billingMenu();
		}
	}
	public static void adminMenu() {
		Scanner sc= new Scanner(System.in);
		Admin a = new Admin();
		String pName;
		int pStock;
		float pPrice;
		int pid;
		
		System.out.println("+---------+");
		System.out.println("|  Admin  |");
		System.out.println("+---------+\n");
		System.out.println("1.Add Product\n2.Edit Product\n3.Remove Product\n4.Delete All Data\n\n9.Main Menu\n0.Exit\n");
		System.out.print("Enter your Option: ");
		
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.print("\nEnter Product Name: ");
			pName = sc.next();
			System.out.print("\nEnter Product Price: ");
			pPrice = sc.nextFloat();
			System.out.print("\nEnter Product Stock: ");
			pStock = sc.nextInt();
			a.add(pName, pPrice, pStock);
			Reports.inventory();
			adminMenu();
		case 2:
			Reports.inventory();
			System.out.print("\nSelect Product: ");
			pid = sc.nextInt();
			System.out.print("\nEnter New Product Name: ");
			pName = sc.next();
			System.out.print("\nEnter New Product Price: ");
			pPrice = sc.nextFloat();
			System.out.print("\nEnter New Product Stock: ");
			pStock = sc.nextInt();
			a.update(pid, pName, pPrice, pStock);
			Reports.inventory();
			adminMenu();
		case 3:
			Reports.inventory();
			System.out.print("\nSelect Product to Remove: ");
			pid = sc.nextInt();
			a.remove(pid);
			Reports.inventory();
			adminMenu();
		case 4:
			a.deleteAll();
			adminMenu();
		case 9:
			mainMenu();
		case 0:
			sc.close();
			System.exit(0);
		default:
			System.out.println("Wrong Input");
			reportMenu();
		}
	}
	public static void reportMenu() {
		Scanner sc= new Scanner(System.in);

		System.out.println("+---------+");
		System.out.println("| Reports |");
		System.out.println("+---------+\n");
		System.out.println("1.Inventory Report\n2.Sale Report\n\n9.Main Menu\n0.Exit\n");
		System.out.print("Enter your Option: ");
		
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			Reports.inventory();
			reportMenu();
		case 2:
			Reports.sales();
			reportMenu();
		case 9:
			mainMenu();
		case 0:
			sc.close();
			System.exit(0);
		default:
			System.out.println("Wrong Input");
			reportMenu();
		}
	}
}
