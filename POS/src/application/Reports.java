package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import database.*;

public class Reports {
	public static void inventory() {
		System.out.println("\n+------------------------------------+");
		System.out.println("| id  |  Product  |  Price  |  Stock |");
		System.out.println("+------------------------------------+");
		File fileObj = Database.getTable("products");
		Scanner myReader;
		try {
			myReader = new Scanner(fileObj);
			while(myReader.hasNextLine()) {
				System.out.println(String.join("  |  ", myReader.nextLine().split(",")));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void sales() {
		System.out.println("\n+-----------------------------+");
		System.out.println("| Bill no  |  Items  |  Total |");
		System.out.println("+-----------------------------+");
		File fileObj = Database.getTable("bills");
		Scanner myReader;
		try {
			myReader = new Scanner(fileObj);
			while(myReader.hasNextLine()) {
				System.out.println(String.join("  |  ", myReader.nextLine().split(",")));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
