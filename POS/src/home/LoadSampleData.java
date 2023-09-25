package home;

import database.Bill;
import database.Product;
import database.Table;

public class LoadSampleData {
	public static void main(String args[]) {
		Table productTableInstance = new Table("products");
		Product p1 = new Product("Book1",10.1f,10);
		Product p2 = new Product("Book2",20.2f,20);
		Product p3 = new Product("Book3",30.3f,30);
		Product p4 = new Product("Book4",40.4f,40);
		productTableInstance.addRow(p1);
		productTableInstance.addRow(p2);
		productTableInstance.addRow(p3);
		productTableInstance.addRow(p4);
		
		Table billTableInstance = new Table("bills");
		Bill b1 = new Bill(4,12.45f);
		Bill b2 = new Bill(2,15.45f);
		Bill b3 = new Bill(7,5.45f);
		billTableInstance.addRow(b1);
		billTableInstance.addRow(b2);
		billTableInstance.addRow(b3);
		System.out.println("Data Loaded Successfully !!!!");
	}
}
