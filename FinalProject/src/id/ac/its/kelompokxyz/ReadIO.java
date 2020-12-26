package id.ac.its.kelompokxyz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadIO extends Data {
	private static final long serialVersionUID = 1L;
	private static ObjectInputStream input;

	public ReadIO() {
		openFile();
		readRecords();
		closeFile();
		
	}
	
	public static void openFile() {
		try {
			input = new ObjectInputStream(
					Files.newInputStream(Paths.get("clients.ser")));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}

	public void readRecords() {
		try {
			Data record = (Data) input.readObject();
			this.setName(record.getName());
			this.setScore(record.getScore());
//			System.out.printf("%s - %d",record.getName(), record.getScore());

		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
		} catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
		}
	}

	public static void closeFile() {
		try {
			if (input != null)
			input.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
			System.exit(1);
		}
	}
}
