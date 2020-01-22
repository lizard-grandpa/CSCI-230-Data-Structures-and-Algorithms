package LectureNotes.JavaProgramming;

import java.util.Random;

/*
 * 	Java allows the use of each of the same data structures we are used to in C++ programming
 * 	even the range-based for loop exemplified below.
 */
public class ControlStructures {

	private static void swap(Character c1, Character c2) {
		Character temp = c1;
		c1 = c2;
		c2 = temp;
	}
	
	public static void main(String[] args) {
		
		// Iterates through each character in the string literal adding 6 to each
		// character value
		for(char c : "SomeString".toCharArray())
			System.out.print( (char) ((c + 6) % 26 + 'a') ); // Offsets the character by 7
		System.out.println();
		char[] encoding = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		// Randomly swap 100 letters
		Random r = new Random();
		for(int i = 0; i < 10; ++i) {
			int idx1 = r.nextInt(encoding.length);
			int idx2 = r.nextInt(encoding.length);
			
			// Example of reference object wrappers for primitives
			Character c1 = encoding[idx1];
			Character c2 = encoding[idx2];
			
			encoding[idx1] = c2.charValue();
			encoding[idx2] = c1.charValue();
		}
		System.out.println("Original: " + "abcdefghijklmnopqrstuvwxyz");
		System.out.println("Encoding: " + new String(encoding));
		
		System.out.println("SomeString");
		for(char c : "SomeString".toCharArray())
			System.out.print(encoding[Character.toLowerCase(c) - 'a']);
	}
}
