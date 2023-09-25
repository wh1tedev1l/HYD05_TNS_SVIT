package database;

public class Product {
	public int id;
	public String name;
	public float price;
	public int stock;
	
	public Product() {}
	
	public Product(String name, float price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public Product(int id, String name, float price, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
}
