package bsma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Purpose: Operating Systems 
 * Status: Adding works, need Remove
 * Last update: 03/27/15
 * Submitted: 
 * Comment: 
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version: 2015.03.27
 * 
 * The BSMA class takes all of the input from the user and uses it to 
 * demonstrate the entire functionality of the binary buddy memory management
 * system
 */
public class BSMA {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	// Data object
	static Data data1;
	
        
	public static void main(String args[]) throws IOException, SizeException {
		System.out.println("Welcome to the Binary Buddy Memory Management System!");
		System.out.println();
		System.out.println("Please enter the amount of memory you would like to allocate for the system (must be a power of 2): ");
		Integer systemSize = Integer.parseInt(reader.readLine());
		Memory memory = new Memory(systemSize); // is this what we are using or are we using MemoryArrayBased?
		System.out.println();
		System.out.println("The minimum memory chunk size is " + memory.MINIMUM_CHUNK_SIZE + ".");

		boolean quit = false;

		do {
			System.out.println();
			System.out.println("Select from the following menu:");
			System.out.println("1. " + "Save data to memory.");
			System.out.println("2. " + "Delete data from memory.");
			System.out.println("3. " + "Print current state of memory.");
			System.out.println("4. " + "Exit program.");
			System.out.println("Make your menu selection now: ");

			String choice = reader.readLine();
			System.out.println();

			switch (choice) {

				case "1":
					//prompt the user for the name of the data they are trying to save and the size of that data
					System.out.println("What is the name of the data you want to save?");
					String dataName = reader.readLine();
					System.out.println("What is the size of " + dataName + "?");
					Integer dataSize = Integer.parseInt(reader.readLine());
					data1 = new Data(dataName, dataSize);
					//TODO need a check here to see if there is enough room for the data
					memory.add(data1);
					System.out.println("You have successfully saved the data!");
					break;

				case "2":
					System.out.println("What is the name of the data you wish to delete?");
					String dataToDelete = reader.readLine();
                                        memory.delData(dataToDelete);
					System.out.println("You have successfully deleted " + dataToDelete + "!");
					break;

				case "3":
					System.out.println(memory.toString());
					break;

				case "4":
					quit = true;
					break;

				default:
					System.out.println("Wrong choice.");
					System.out.println();
					break;
			}
		} while (!quit);
		System.out.println("Goodbye.");
		System.exit(1);
	}
}
