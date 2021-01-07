package id.ac.its.kelompokxyz.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO extends Data{
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	
	public IO() {
		
	}
	
	public void createFile(int score, String name) {
		try {
			output = new ObjectOutputStream(
					Files.newOutputStream(Paths.get("clients.ser")));
			Data record = new Data(score, name);
			output.writeObject(record);
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	
	

}
