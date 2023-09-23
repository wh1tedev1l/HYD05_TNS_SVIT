package filehandling;
import java.io.*;
import java.io.IOException;
import java.util.*;

public class FileHandling {
	
	public void createFile(String fileName) {
		try {
			File fileObj = new File(fileName+".txt");
			if (fileObj.createNewFile()) {
				System.out.println("File Created: "+fileObj.getName());
			}
			else {
				System.out.println("File Already Exists !!");
			}
		} catch(IOException e) {
			System.out.println("Error Occured while Creating");
			e.printStackTrace();
		}	
	}
	
	public void writeIntoFile(String fileName,String data ) {
		try {
			FileWriter writerObj=new FileWriter(fileName+".txt");
			writerObj.write(data);
			writerObj.close();
			System.out.println("Data Inserted Successfully");
		}
		catch(IOException e) {
			System.out.println("Error occured while Writing");
			e.printStackTrace();
		}
	}
	
	public void readFile(String fileName) {
		try {
			File fileObj = new File(fileName+".txt");
			Scanner myReader = new Scanner(fileObj);
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error Occured while Reading");
			e.printStackTrace();
		}
	}
		
	public void deleteFile(String fileName) {
		File fileObj = new File(fileName+".txt");
		if(fileObj.delete()) {
			System.out.println("file "+fileObj.getName()+" has been deleted");
		}
		else {
			System.out.println("Error Occured while Deleting");
		}
	}
}
