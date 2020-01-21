package LectureNotes.JavaProgramming;

import java.util.Scanner;	// Facilitates input operations

/*
 * 	Java provides various input and output functions. The Scanner object is similar to the extraction operator (<<) from C++
 *  in the sense that it uses whitespace as a delimiter, that is, text can be read using a scanner object until a white space is
 *  encounter.
 *  
 *  Java also provides the print, println (print line), and printf (print formatter) member functions.
 */
public class BasicInputOutput {

	public static void main(String[] args) {
		
		// Basic input
		Scanner input = new Scanner(System.in);	// Read output from standard input
		
		int x       = input.nextInt();			// Read a single integer
		String line = input.nextLine();			// Read an entire line of text
		String str  = input.next();				// Read until delimiter (whitespace) is encountered
		char c      = input.next().charAt(0);	// Extracts the first character from a string of characters
		
		// Basic output
		System.out.print("String Literal" + x + line + str + c + "\n");
		System.out.println("Adds a new line character at the end of this statement.");
		System.out.printf("Formatted String: %x %s %c\n", x, str, c);

	}

}
