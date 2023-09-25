package application;

import java.util.ArrayList;
import java.util.List;
import database.*;

public class Cart extends Billing{
	static List<CartItem> cart = new ArrayList<CartItem>();
	Table productTableInstance = new Table("products");
	Table billTableInstance = new Table("bills");
	
	public void displayItems() {
		System.out.println("\n+------------+");
		System.out.println("| Cart Items |");
		System.out.println("+------------+\n");
		System.out.println("======================\n");
		for(int i=1;i<=cart.size();i++) {
			CartItem c = cart.get(i-1);
			System.out.println(i+"."+c.name+"  "+c.quantity+"  "+c.total);
		}
		System.out.println("======================\n");
	}
	
	public boolean addItem(int id, int q) {
		
		Product p = new Product();
		CartItem c = new CartItem();
		p = productTableInstance.getById(id-1);
		
		c.id = p.id; c.name = p.name; c.quantity = q; c.total = p.price * q;
		
		cart.add(c);
		System.out.println("cart size"+cart.size());
		p.stock = p.stock-q;
		
		productTableInstance.updateRow(p.id, p);
		
		return true;
	}
	
	public boolean removeItem(int id) {
		cart.remove(id-1);
		return true;
	}
	public void proceed() {
		System.out.println("\n=======================");
		System.out.println("+------------+");
		System.out.println("|    BILL    |");
		System.out.println("+------------+\n");
		Float totalSale = 0.0f;
		int totalItems = 0;
		for(int i=1;i<=cart.size();i++) {
			CartItem c = cart.get(i-1);
			totalSale = totalSale + c.total;
			totalItems = totalItems + c.quantity;
			System.out.println(i+"."+c.name+"  "+c.quantity+"  "+c.total+"\n");
		}
		System.out.println("=======================");
		System.out.println("  TOTAL  "+totalItems+"  "+totalSale);
		System.out.println("=======================");
		System.out.println("=======================\n");
		
		Bill b = new Bill(totalItems, totalSale);
		billTableInstance.addRow(b);
		cart.clear();
	}
	
}
