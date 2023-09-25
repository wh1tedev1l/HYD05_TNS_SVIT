package application;

import database.*;

public class Admin {
	Table productTableInstance = new Table("products");
	Table billTableInstance = new Table("bills");
	
	public void add(String name, float price, int stock) {
		Product newProduct = new Product(name, price, stock);
		productTableInstance.addRow(newProduct);
	}
	
	public void update(int pid,String name, float price, int stock) {
		Product newProduct = new Product(name, price, stock);
		productTableInstance.updateRow(pid,newProduct);
	}
	
	public void remove(int pid) {
		productTableInstance.removeRow(pid);
	}

	public void deleteAll() {
		Database.delete("products");
		Database.delete("bills");
	}
}
