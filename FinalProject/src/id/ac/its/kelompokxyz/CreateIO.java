package id.ac.its.kelompokxyz;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateIO {
	private static ObjectOutputStream output;
	
	public CreateIO(int score, String name) {
		openFile();
		setRecords(score, name);
		closeFile();
	}
	
	public static void openFile() {
		try {
			output = new ObjectOutputStream(
					Files.newOutputStream(Paths.get("clients.ser")));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	
	public static void setRecords(int score, String name) {
		try {
			Data record = new Data(score, name);
			output.writeObject(record);
			
		} catch (IOException ioException) {
			System.err.println("Error writing to file. Terminating.");
			
		}
	}
	
	public static void closeFile() {
		try {
			if (output != null)
			output.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
		}
	}
}
