package database;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Database {
	
	public static void initialize(String tableName) {
		try {
			File fileObj = new File(tableName+".csv");
			if (fileObj.createNewFile()) {
				System.out.println("File Created: "+fileObj.getName());
			}
		} catch(IOException e) {
			System.out.println("Error Occured while Creating Table:"+tableName);
			e.printStackTrace();
		}
	}
	
	public static void delete(String tableName) {
		File fileObj = new File(tableName+".csv");
		if(fileObj.delete()) {
			System.out.println(fileObj.getName()+" Table deleted Successfully !!");
		}
		else {
			System.out.println("Error Occured while Deleting Table: "+fileObj.getName());
		}
	}
	
	public static File getTable(String tableName) {
		File fileObj = null;
		fileObj = new File(tableName+".csv");
		return fileObj;
	}
	
	public static void writeData(String file, String data) {
		try {
			FileWriter writerObj=new FileWriter(file+".csv",true);
			writerObj.write(data);
			writerObj.close();
		}
		catch(IOException e) {
			System.out.println("Error occured while Writing");
			e.printStackTrace();
		}
	}
	
	public static int lastId(String file) {
		int count = 0;
		try {
			File fileObj = new File(file+".csv");
			Scanner myReader = new Scanner(fileObj);
			while(myReader.hasNextLine()) {
				myReader.nextLine();
				count++;
			}
			myReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error Occured while Reading");
			e.printStackTrace();
		}
		return count;
	}
	
	public static boolean findAndReplace(String file,int id, String newString) {
		try {
			File fileObj = new File(file+".csv");
			String data = "";
			Scanner myReader = new Scanner(fileObj);
			
			for(int i=0;myReader.hasNextLine();i++) {
				if(i == id) {
					data = data+newString+System.lineSeparator();
					myReader.nextLine();
				} else {
					data = data+myReader.nextLine()+System.lineSeparator();
				}
			}
			myReader.close();
			
			FileWriter writerObj=new FileWriter(file+".csv");
			writerObj.write(data);
			writerObj.close();
			
			return true;
		}
		catch(FileNotFoundException e) {
			System.out.println("Error Occured while Updating File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error occured while Writing Update");
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean findAndDelete(String file, int id) {
		try {
			File fileObj = new File(file+".csv");
			String data = "";
			String[] temp;
			Scanner myReader = new Scanner(fileObj);
			
			for(int i=0;myReader.hasNextLine();i++) {
				if(i == id) {
					data = data+"";
					myReader.nextLine();
					break;
				} else {
					data = data+myReader.nextLine()+System.lineSeparator();
				}
			}
			
			while(myReader.hasNextLine()) {
				temp = myReader.nextLine().split(",");
				temp[0] = Integer.toString(Integer.parseInt(temp[0])-1);
				data = data+String.join(",", temp)+System.lineSeparator();			
			}
			
			myReader.close();
			FileWriter writerObj=new FileWriter(file+".csv");
			writerObj.write(data);
			writerObj.close();
			
			return true;
		}
		catch(FileNotFoundException e) {
			System.out.println("Error Occured while Updating File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error occured while Writing Update");
			e.printStackTrace();
		}
		return false;
	}
	public static String findItem(String file, int id) {
		try {
			File fileObj = new File(file+".csv");
			String data = "";
			Scanner myReader = new Scanner(fileObj);
			
			for(int i=0;myReader.hasNextLine();i++) {
				if(i == id) {
					data = myReader.nextLine();
					break;
				} else {
					myReader.nextLine();
				}
			}
			myReader.close();
			return data;
		}
		catch(FileNotFoundException e) {
			System.out.println("Error Occured while Updating File Not Found");
			e.printStackTrace();
		}
		return "";
	}
}
