package database;

public class Bill {
	int id;
	int items;
	float sale;
	
	public Bill(int items, float sale) {
		this.items = items;
		this.sale = sale;
	}
}
