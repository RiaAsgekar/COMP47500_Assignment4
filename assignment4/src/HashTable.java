import java.util.LinkedList;

// Class representing a HashTable data structure
public class HashTable {
    private LinkedList<String>[] table; // Array of LinkedLists to store key-value pairs

    // Constructor to initialize the HashTable
    @SuppressWarnings("unchecked")
    public HashTable() {
        table = (LinkedList<String>[]) new LinkedList[26]; // Create an array of LinkedLists, one for each letter of the alphabet
        for (int i = 0; i < 26; i++) {
            table[i] = new LinkedList<>(); // Initialize each LinkedList
        }
    }

    // Method to compute the hash value of a given key
    private int hash(String key) {
        char firstLetter = key.toLowerCase().charAt(0); // Get the first letter of the key
        return firstLetter - 'a'; // Return the index of the corresponding linked list
    }

    // Method to add a key to the HashTable
    public void put(String key) {
        int index = hash(key); // Compute the index for the key
        LinkedList<String> bucket = table[index]; // Get the corresponding LinkedList
        bucket.add(key); // Add the key to the LinkedList
    }

    // Method to check if the HashTable contains a given key
    public boolean contains(String key) {
        int index = hash(key); // Compute the index for the key
        LinkedList<String> bucket = table[index]; // Get the corresponding LinkedList
        return bucket.contains(key); // Check if the LinkedList contains the key
    }
}
