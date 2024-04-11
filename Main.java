package assignment4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) {
        HashTable hashtable = new HashTable();
        LinkedList<String> LL = new LinkedList<String>();

        // insertion
        try {
            @SuppressWarnings("deprecation")
			URL url = new URL("https://www.andrew.cmu.edu/course/15-200/f06/applications/labs/lab2/dict.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            long HTtotalTime = 0;
            long LLtotalTime = 0;
            int wordsProcessed = 0;
            
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    if (Character.isLetter(word.charAt(0))) {
                    	long startTime = System.nanoTime();
                        hashtable.put(word);
                        long endTime = System.nanoTime();
                        HTtotalTime += (endTime - startTime);
                        
                        startTime = System.nanoTime();
                        LL.add(word);
                        endTime = System.nanoTime();
                        LLtotalTime += (endTime - startTime);
                        
                        wordsProcessed++;
                    }
                }
            }
            reader.close();
            if (wordsProcessed > 0) {
            	System.out.println("Average time taken to insert into hashtable: " + (HTtotalTime / (double) wordsProcessed)+" nanoseconds");
            	System.out.println("Average time taken to insert into linked list: " + (LLtotalTime / (double) wordsProcessed)+" nanoseconds");
            } else {
                System.out.println("No words processed.");
            }
        } catch (Exception e) {
            System.err.println("Error reading from URL: " + e.getMessage());
        }

        // spell checker:
        String[] words = {
        	    // Real Words
        	    "apple", "banana", "cat", "dog", "elephant", "fish", "guitar", "house", "igloo", "jelly",
        	    "kangaroo", "lion", "monkey", "nurse", "orange", "parrot", "queen", "rabbit", "snake", "tiger",
        	    "umbrella", "violin", "whale", "xylophone", "yogurt", "zebra", "ant", "bear", "butterfly",
        	    "camel", "duck", "eagle", "frog", "giraffe", "horse", "insect", "jaguar", "koala", "lizard",
        	    "mouse", "nightingale", "owl", "panda", "quail", "raccoon", "squirrel", "turtle", "unicorn",
        	    "vulture", "wolf",
        	    // Misspelled Words
        	    "aple", "bnana", "catt", "dawg", "elefant", "fsh", "gutar", "houz", "iglou", "jely",
        	    "kangooroo", "lyin", "monkay", "nurs", "orng", "parot", "quean", "rabit", "snak", "tigar",
        	    "umbrela", "violn", "wale", "xilofone", "yohurt", "zebruh", "aunt", "ber", "buterfly",
        	    "camal", "duk", "egel", "frug", "jiraf", "hors", "insct", "jagur", "koala", "lizrd",
        	    "mous", "nitingale", "owel", "panduh", "quayl", "racun", "squril", "turtul", "unikorn",
        	    "vulchur", "wulf"
        	};
        long HTtotalTime = 0;
        long LLtotalTime = 0;
        int wordsProcessed = 0;
        for (String word : words) {
            long startTime = System.nanoTime();
            hashtable.contains(word);//if returns true then spelling is correct, else it is not
            long endTime = System.nanoTime();
            HTtotalTime += (endTime - startTime);

            startTime = System.nanoTime();
            LL.contains(word);
            endTime = System.nanoTime();
            LLtotalTime += (endTime - startTime);

            wordsProcessed++;
        }
        
        System.out.println("Average time taken to search in hashtable: " + (HTtotalTime / (double) wordsProcessed)+" nanoseconds");
    	System.out.println("Average time taken to search in linked list: " + (LLtotalTime / (double) wordsProcessed)+" nanoseconds");
    }
}
