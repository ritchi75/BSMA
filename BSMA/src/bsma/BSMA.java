package bsma;
import java.io.*;

/*
 * Purpose: Operating Systems 
 * Status: other classes need work before it can be completed
 * Last update: 03/19/15
 * Submitted: 
 * Comment: 
 * @author: Greg Richards
 * @version: 2015.03.19
 * 
 * the BSMA class takes all of the input from the user and uses it to demonstrate
 * the entire functionality of the binary buddy memory management system
 */
public class BSMA
{
    static BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException
    {
        System.out.println("Welcome to the Binary Buddy Memory Management System!");
        System.out.println();
        System.out.println("Please enter the amount of memory you would like to allocate for the system (must be a power of 2): ");
        Integer systemSize = Integer.parseInt(reader.readLine());
        // TODO use the systemSize to create the initial memory chunk
        Memory memory = new Memory(); // TODO change Memory class to be able to use different sizes based on user input
        
        System.out.println();
        System.out.println("The minimum memory chunk size is " +  memory.MINIMUM_CHUNK_SIZE + ".");
        
        boolean quit = false;

        do{
            System.out.println();
            System.out.println("Select from the following menu:");
            System.out.println("1. " + "Save file to memory.");
            System.out.println("2. " + "Delete file from memory.");
            System.out.println("3. " + "Print current state of memory.");
            System.out.println("4. " + "Exit program.");
            System.out.println("Make your menu selection now: ");
            
            String choice = reader.readLine();
            System.out.println();
            
            switch (choice) {

                case "1": 
                //prompt the user for the name of the file they are trying to save and the size of that file
                    System.out.println("What is the name of the file you want to save?");
                    String fileName = reader.readLine();
                    System.out.println("What is the size of " + fileName + "?");
                    Integer fileSize = Integer.parseInt(reader.readLine());
                    //TODO need to make a file class so we can create one here
                    // I don't think we should use javas File class
                    //TODO need a check here to see if there is enough room for the file 
                    System.out.println("You have successfully saved the file!");
                break;

                case "2":
                    System.out.println("What is the name of the file you wish to delete?");
                    String fileToDelete = reader.readLine();
                    //TODO call the method that will search for the necessary file, delete 
                    //it, and merge memory chunks if necessary
                    System.out.println("You have successfully deleted " + fileToDelete + "!");
                break;

                case "3":
                    //TODO call toString() method of the memory
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
