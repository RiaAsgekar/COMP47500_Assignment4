import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.FileReader;

public class Main {
	
    public static void main(String[] args) {
        HashTable hashtable = new HashTable(); // Initialize a new hash table
        LinkedList<String> LL = new LinkedList<String>(); // Initialize a new linked list

        // insertion
        try {
            @SuppressWarnings("deprecation")
			URL url = new URL("https://www.andrew.cmu.edu/course/15-200/f06/applications/labs/lab2/dict.txt"); // URL of dictionary
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream())); // Open connection to URL

            String line;
            long HTtotalTime = 0; // Total time for hash table insertion
            long LLtotalTime = 0; // Total time for linked list insertion
            int wordsProcessed = 0; // Total number of words processed
            
            // Read each line from the dictionary
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line); // Tokenize each line
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken(); // Get the next token
                    if (Character.isLetter(word.charAt(0))) { // Check if the token is a word
                    	long startTime = System.nanoTime(); // Start timing
                        hashtable.put(word); // Insert word into hash table
                        long endTime = System.nanoTime(); // End timing
                        HTtotalTime += (endTime - startTime); // Update total time for hash table insertion
                        
                        startTime = System.nanoTime(); // Start timing
                        LL.add(word); // Insert word into linked list
                        endTime = System.nanoTime(); // End timing
                        LLtotalTime += (endTime - startTime); // Update total time for linked list insertion
                        
                        wordsProcessed++; // Increment word count
                    }
                }
            }
            reader.close(); // Close the reader
            if (wordsProcessed > 0) {
            	// Print average time taken for insertion into hash table and linked list
            	System.out.println("Average time taken to insert into hashtable: " + (HTtotalTime / (double) wordsProcessed)+" nanoseconds");
            	System.out.println("Average time taken to insert into linked list: " + (LLtotalTime / (double) wordsProcessed)+" nanoseconds");
            } else {
                System.out.println("No words processed.");
            }
        } catch (Exception e) {
            System.err.println("Error reading from URL: " + e.getMessage()); // Handle any exceptions
        }

        // spell checker:
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\College\\Advanced Data Structures in Java\\assignment4\\src\\words.txt")); // Reading words from file

            long HTtotalTime = 0; // Total time for hash table search
            long LLtotalTime = 0; // Total time for linked list search
            int wordsProcessed = 0; // Total number of words processed
            String line;
            
            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line); // Tokenize each line
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken(); // Get the next token
                    long startTime = System.nanoTime(); // Start timing
                    hashtable.contains(word); // Search for word in hash table
                    long endTime = System.nanoTime(); // End timing
                    HTtotalTime += (endTime - startTime); // Update total time for hash table search

                    startTime = System.nanoTime(); // Start timing
                    LL.contains(word); // Search for word in linked list
                    endTime = System.nanoTime(); // End timing
                    LLtotalTime += (endTime - startTime); // Update total time for linked list search

                    wordsProcessed++; // Increment word count
                }
            }
            reader.close(); // Close the reader
            
            if (wordsProcessed > 0) {
                // Print average time taken for search in hash table and linked list
                System.out.println("Average time taken to search in hashtable: " + (HTtotalTime / (double) wordsProcessed)+" nanoseconds");
                System.out.println("Average time taken to search in linked list: " + (LLtotalTime / (double) wordsProcessed)+" nanoseconds");
            } else {
                System.out.println("No words processed.");
            }
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e.getMessage()); // Handle any exceptions
        }
    }
}
