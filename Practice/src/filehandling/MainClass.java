package filehandling;

public class MainClass {
	public static void main(String args[]) {
		FileHandling obj = new FileHandling();
		obj.createFile("test");
		obj.writeIntoFile("test", "Hello World");
		obj.readFile("test");
		// obj.deleteFile("test");
	}
}
