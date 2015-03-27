 

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
public class BSMA 
{

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean running = true;
    // Data object
    static Data data1;
    
        
    public static void main(String args[]) throws IOException, SizeException 
    {
        //prints welcom and initilizes momory parameters
        
        System.out.println("Welcome to the Binary Buddy Memory Management System!");
        System.out.println();
        System.out.println("Please enter the amount of memory you would like to allocate for the system (must be a power of 2): ");
        Integer systemSize = Integer.parseInt(reader.readLine());
        Memory memory = new Memory(systemSize); // is this what we are using or are we using MemoryArrayBased?
        System.out.println();
        System.out.println("The minimum memory chunk size is " + memory.MINIMUM_CHUNK_SIZE + ".");

        do 
        {
            //prints menu option
            
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
                    String dataName = readUniqueName(memory);
                    System.out.println("What is the size of " + dataName + "?");
                    int dataSize = readInt();
                        
                    try
                    {
                        memory.addData(new Data(dataName, dataSize));
                        System.out.println("You have successfully saved the data!");
                    }
                    catch(SizeException s)
                    {
                        System.out.println("There is no room for data of size " + dataSize + "\n");
                    }
                    
                    break;

                case "2":
                    System.out.println("What is the name of the data you wish to delete?");
                    String dataToDelete = reader.readLine();
                    
                    try
                    {
                        memory.deleteData(memory.getIndex(dataToDelete));
                        System.out.println("You have successfully deleted " + dataToDelete + "!");
                    } 
                    catch (NullPointerException n)
                    {
                        System.out.println("there is no file by that name.");
                    }
                    
                    break;

                case "3":
                    System.out.println(memory.toString());
                    break;

                case "4":
                    running = false;
                    break;

                default:
                    System.out.println("Wrong choice.");
                    System.out.println();
                    break;
            }
        } while (running);
        System.out.println("Goodbye.");
        System.exit(1);
    }
    
    /**
     * Reads and returns an integer from standard input.  This method
     * is compleate with exception handleing and will not exit intill
     * an integer has been successfully read from the standard input.
     * 
     * @return  an integer read from standard input
     */
    private static int readInt() throws IOException
    {
        int integer = 0;
        boolean notCorrect = true;
        do
        {
            try
            {
                integer = Integer.parseInt(reader.readLine());
                notCorrect = false;
            }
            catch (NumberFormatException ex)
            {
                System.out.println("\n" + "    **ERROR**" + "\n" + "You must enter interter value." + "\n"
                + "try again\n");
            }
        }while(notCorrect);
        return integer; 
    }
    
    /**
     * 
     */
    private static String readUniqueName(Memory memory) throws IOException
    {
        boolean notCorrectInput = true;
        String returnString = "";
        do
        {
            returnString = reader.readLine();
            try
            {
                memory.getIndex(returnString);
                System.out.println("there is already a data file by that name in memory.  Try again");
            }
            catch (NullPointerException n)
            {
                notCorrectInput = false;
            }
        }while (notCorrectInput);
        return returnString;
    }
}
