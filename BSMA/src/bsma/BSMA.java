import java.io.BufferedReader;
import java.io.*;
/*
 * Purpose: Operating Systems 
 * @author Ray Heng
 * @author Nathan Leilich
 * @author Greg Richards
 * @author Scott Ritchie
 * @version: 2015.03.29
 * 
 * The BSMA class takes all of the input from the user and uses it to 
 * demonstrate the entire functionality of the buddy memory management
 * system
 */
public class BSMA {

    private static final BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean running = true;

    public static void main(String args[]) throws IOException, SizeException, InterruptedException {
        
        boolean runningInput = true;
        //prints welcome
        System.out.println("\n\n___________________________________________"
                + "___________");
        System.out.println("Welcome to the Binary Buddy Memory "
                + "Management System!");
        do{
            System.out.println("1. run with manual input");
            System.out.println("2. run integration plan from file");
            String choice = Reader.readLine();
            switch (choice) {
                case "1":  runSimulation(Reader, false);
                           break;
                case "2":  runSimulation(new BufferedReader(new FileReader(new File("demo.txt"))), true);
                           break;
                default:   System.out.println("invalid input");
                           break;
            }
            
            System.out.println("run again?");
            System.out.println("1. yes");
            System.out.println("2. no (exits program)");
            choice = Reader.readLine();
            switch (choice) {
                case "1":  runningInput = true;
                           break;
                case "2":  running = false;
                           break;
                default:   System.out.println("invalid input");
                           break;
            }
        }while (running);
        System.out.println("terminating program.");        
        System.exit(1);
    }

    /**
     * 
     */
    private static void runSimulation(BufferedReader reader, boolean readingFromFile) throws IOException, SizeException, InterruptedException
    {
        boolean runningInput = true;      
        
        Memory memory = getNewMemory(reader);
            System.out.println();
            System.out.println("The minimum memory chunk size is "
                + Memory.MINIMUM_CHUNK_SIZE + ".");

            do {

                // Prints menu options
                System.out.println("\n<<<<<<<   Main Menu   >>>>>>>>>>>\n");
                System.out.println("Select from the following menu:");
                System.out.println("1. " + "Save data to memory.");
                System.out.println("2. " + "Delete data from memory.");
                System.out.println("3. " + "Print current state of memory.");
                System.out.println("4. " + "Print the amount of wasted and "
                                    + "available memory.");
                System.out.println("5. " + "Clear memory.");
                System.out.println("6. " + "Reset the system.");
                System.out.println("exit. " + "Exit program.");
                System.out.print("Make your menu selection now:  ");

                String choice = reader.readLine();
                System.out.println(" --- " + choice + "\n");
                switch (choice) {

                    /**
                    * Prompt the user for the name and size of the data they'd like
                    * to save.
                    */
                    case "1":  System.out.println(" --- What is the name of the data you "
                               + "want to save?");
                               String dataName = reader.readLine();//readUniqueName(memory);
                               System.out.println(" --- What is the size of "
                               + dataName + "?");
                               int dataSize = readInt(reader);
                               try {
                                   memory.addData(new Data(dataName, dataSize));
                                   System.out.println(" --- " + dataSize + " saved");
                               }
                               catch (SizeException s) {
                                    System.out.println("\n    ****** ERROR ****** \n"
                                    + s.getMessage() + "\n");
                               }
                               break;

                    /**
                 * Prompt the user for the name of the data they'd like to
                 * delete.
                 */
                case "2":
                    System.out.println(" --- What location would you like to "
                            + "delete data from?");
                    int locationToDelete = Integer.parseInt(reader.readLine());

                    try {
                        memory.deleteData(memory.getIndex(locationToDelete));
                        System.out.println(" --- You have successfully "
                                + "deleted data from" + locationToDelete + "!");
                    } catch (NullPointerException n) {
                        System.out.println("\n    ****** ERROR ******\n" 
                                + n.getMessage() + "\n");
                    }
                    break;

                /**
                 * Print out the status of the Memory object. What chunks are
                 * available, and what chunks contain Data.
                 */
                case "3":
                    System.out.println("\n---------------------------------"
                            + "-----");
                    System.out.println(memory.toString());
                    break;

                /**
                 * Prints the memory wasted as well as memory available.
                 */
                case "4":
                    System.out.println("\n---------------------------------"
                            + "-----");
                    System.out.println("Wasted Memory: " 
                            + memory.getTotalWasted());     
                    System.out.println("Available Memory: " 
                            + memory.getTotalAvailable());
                    break;

                /**
                 * Clears Memory of all Data.
                 */
                case "5":
                    memory.clearMemory();
                    System.out.println(" --- You have successfully cleared "
                            + "the memory!");
                    break;

                /**
                 * Recreates the Memory object with a size determined by the
                 * user.
                 */
                case "6":
                    memory = getNewMemory(reader);
                    break;

                /**
                 * Ends program.
                 */
                case "exit":
                    runningInput = false;
                    break;

                /**
                 * Prints that you have chosen a case that doesn't exist.
                 */
                default:
                    System.out.println("\n     ****** ERROR ******\n"
                            + "invalid input\n");
                    System.out.println();
                    break;
            }
        if(readingFromFile)
        {
            Thread.sleep(1000);
        }
        }while (runningInput);
    }
    
    /**
     * Reads and returns an integer from standard input. This method is
     * complete with exception handling and will not exit until an integer
     * has been successfully read from the standard input.
     *
     * @return an integer read from standard input
     */
    private static int readInt(BufferedReader reader) throws IOException {
        int integer = 0;
        boolean notCorrect = true;
        do {
            try {
                integer = Integer.parseInt(reader.readLine());
                notCorrect = false;
            } catch (NumberFormatException ex) {
                System.out.println("\n    ****** ERROR ******" + "\n" 
                        + "You must enter interter value." + "\n" 
                        + "try again\n");
            }
        } while (notCorrect);
        return integer;
    }

    /**
     *
     */
    private static Memory getNewMemory(BufferedReader reader) throws IOException {
        System.out.print("Please enter the amount of memory you would like to\n"
                + "allocate for the system (must be a power of 2):   ");
        boolean notCorrectInput = true;
        int size = -1;
        Memory memory = null;
        do {
            size = readInt(reader);
            try {
                memory = new Memory(size);
                notCorrectInput = false;
            } catch (SizeException s) {
                System.out.println("\n   ****** ERROR ******\n" 
                        + s.getMessage() + "\n");
            }
        } while (notCorrectInput);
        System.out.println(" --- " + size + "\n");
        return memory;
    }
}
