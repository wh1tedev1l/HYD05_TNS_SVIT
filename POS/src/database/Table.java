package database;

public class Table {
	private String tableName;
	private static int count = 0;
	public Table(String table) {
		this.tableName = table;
		Database.initialize(tableName);
		Table.count = Database.lastId(tableName);
	}
	
	public int addRow(Product product) {
		Database.writeData(tableName, count+",");
		Database.writeData(tableName, product.name+",");
		Database.writeData(tableName, product.price+",");
		Database.writeData(tableName, product.stock+"\n");
		count++;
		return count-1;
	}
	
	public int addRow(Bill bill) {
		Database.writeData(tableName, count+",");
		Database.writeData(tableName, bill.items+",");
		Database.writeData(tableName, bill.sale+"\n");
		count++;
		return count-1;
	}
	
	public int updateRow(int id, Product newProduct) {
		String newData = id+","+newProduct.name+","+newProduct.price+","+newProduct.stock;
		Database.findAndReplace(tableName, id, newData);
		return 0;
	}
	
	public int updateRow(int id, Bill bill) {
		String newData = id+","+bill.items+","+bill.sale;
		Database.findAndReplace(tableName, id, newData);
		return 0;
	}
	
	public boolean removeRow(int id) {
		Database.findAndDelete(tableName, id);
		return false;
	}
	
	public Product getById(int id) {
		String itemString = Database.findItem(tableName,id);
		String[] itemStringArray = itemString.split(",");
		int pid = Integer.parseInt(itemStringArray[0]);
		String pname = itemStringArray[1];
		float pprice = Float.parseFloat(itemStringArray[2]);
		int pstock = Integer.parseInt(itemStringArray[3]);
		Product item = new Product(pid, pname, pprice, pstock);
		return item;
	}
	
}
