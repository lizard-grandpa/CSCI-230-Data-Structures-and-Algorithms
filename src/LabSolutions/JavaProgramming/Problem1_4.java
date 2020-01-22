package LabSolutions.JavaProgramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem1_4 {

	private static int CHAR_COUNT = (int) Math.pow(2, 16);	// Java uses 2 bytes (16 bits) for the char data type, therefore,
																	// we have 2^16 possible characters
	
	/*
	 * Returns true if str1 and str2 are encodings of each other (allows the use of ANY symbol). Creates two arrays whose
	 * indices correspond to encodings of a character. For example, array['a'] = 'c' means 'a' is encoded with 'c'. This method
	 * works since characters can be converted to integers...swanky!
	 */
	static boolean isEncodingArray(String str1, String str2) {
		
		// Prematurely terminate if the strings are not of equal length
		if(str1.length() != str2.length()) return false;
		
		// Encoding is case invariant (i.e. 'A' is same as 'a')
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
				
		// Character[] as opposed to char[] allows us to check for null reference, otherwise we would need to check for
		// a sentinel value (maybe 0) which is a valid character
		Character[] rightEncoding = new Character[CHAR_COUNT];
		Character[] leftEncoding  = new Character[CHAR_COUNT];
		
		// For each character in both strings
		for(int i = 0; i < str1.length(); ++i) {
			
			// Have NOT seen the character before, add
			if(rightEncoding[str1.charAt(i)] == null) { 
				rightEncoding[str1.charAt(i)] = str2.charAt(i);
				leftEncoding[str2.charAt(i)] = str1.charAt(i);
			}
			
			// Have seen the character before, check match
			else if(rightEncoding[str1.charAt(i)] != str2.charAt(i) || leftEncoding[str2.charAt(i)] != str1.charAt(i))
				return false;
			
		}
		
		return true;
	}
	
	/*
	 * 	More space efficient method (only keep track of characters we have seen) using an ADVANCED data structure covered later
	 * 	in the class. (I'm surprised many students knew about this method. Kudos to you!)
	 */
	static boolean isEncodingMap(String str1, String str2) {
		
		
		// Prematurely terminate if the strings are not of equal length
		if(str1.length() != str2.length()) return false;
		
		// Encoding is case invariant (i.e. 'A' is same as 'a')
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		// A map is a data structure which associates key-value pairs using keys to look up values. Arrays do this naturally
		// where arrayName[4] = 10 associates key 4 with value 10 but now we can use ANYTHING, maybe even Strings
		// fruit["Yellow"] = "Banana" but then we cannot create fruit["Yellow"] = "Lemon" which I exploit below using the
		// *putIfAbsent* method
		HashMap<Character, Character> rightEncoding = new HashMap<>();	// Encoding from str1 to str2
		HashMap<Character, Character> leftEncoding = new HashMap<>();	// Encoding from str2 to str1
		
		// For each character
		for(int i = 0; i < str1.length(); ++i) {
			
			Character encodingValue;	// Store the result of the putIfAbsent method
			
			// If key does not exist, create (key, value) mapping and return null; otherwise, return value
			encodingValue = rightEncoding.putIfAbsent(str1.charAt(i), str2.charAt(i));
			
			// If null was not return (i.e., mapping exists) and mapping is not consistent with new value, return false
			if(encodingValue != null && encodingValue != str2.charAt(i)) return false;
			
			encodingValue = leftEncoding.putIfAbsent(str2.charAt(i), str1.charAt(i));
			if(encodingValue != null && encodingValue != str1.charAt(i)) return false;
		}
		
		return true;
	}
	
	/*
	 * 	Tests the isEncodingArray and isEncodingMap implementations using the English dictionary.
	 */
	public static void main(String[] args) {
		
		BufferedReader input = null;	// Used for efficient reading
		
		// Initialize file input stream
		try { input = new BufferedReader(new FileReader("words.txt"));}
		catch(IOException e) {
			System.out.println("File does not exist!");
			System.exit(1);
		}
		
		ArrayList<String> words = new ArrayList<>();
	
		String line;
		
		// Read lines of words (each word has its own line) into the array list
		try { while((line = input.readLine()) != null) words.add(line);}
		catch(IOException e) { System.out.println("File read error");}

		// For each pair of words, check if it is an encoding (careful there are about half a million words for 250 billion iterations...ouch!)
		for(int i = 0; i < words.size(); ++i) {
			for(int j = i + 1; j < words.size(); j++) 
				if(isEncodingArray(words.get(i), words.get(j)))
					System.out.println (words.get(i) + " is an encoding of " + words.get(j));
			if(i % 10 == 0)
				try {
					System.out.println("Processed " + i + " words.\n-----Press [ENTER] to continue-----");
					System.in.read();
				} catch(IOException e) {}
		}
	}
}

