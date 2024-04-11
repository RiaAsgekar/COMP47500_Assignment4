package assignment4;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<String>[] table;

    @SuppressWarnings("unchecked")
	public HashTable() {
        table = (LinkedList<String>[]) new LinkedList[26]; // each linked list corresponds to a letter of the alphabet
        for (int i = 0; i < 26; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {// function to compute hash value
        char firstLetter = key.toLowerCase().charAt(0);
        return firstLetter - 'a'; //this hash function returns the index of the corresponding linked list
    }

    public void put(String key) { //function to add to hash table
        int index = hash(key);
        LinkedList<String> bucket = table[index];
        bucket.add(key);
    }

    public boolean contains(String key) { //function to check if hash table contains the key
        int index = hash(key);
        LinkedList<String> bucket = table[index];
        return bucket.contains(key);
    }
}