package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import database.Database;

public class Billing {
	public void displayItems() {
		File fileObj = Database.getTable("products");
		Scanner myReader;
		String[] temp;
		try {
			System.out.println("+-------------+");
			System.out.println("| Select Item |");
			System.out.println("+-------------+\n");
			System.out.println("Name     Stock\n");
			myReader = new Scanner(fileObj);
			while(myReader.hasNextLine()) {
				temp = myReader.nextLine().split(",");
				System.out.println(Integer.toString(Integer.parseInt(temp[0])+1)+"."+temp[1]+"  -  "+temp[3]);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
