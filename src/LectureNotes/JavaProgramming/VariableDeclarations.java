package LectureNotes.JavaProgramming;

import java.util.Scanner;

/*
 * 	Variable declarations in the Java Programming language are similar to to the C++
 *  programming language. There is still a distinction between primitive and non-primitive
 *  data types (e.g., int, char, bool, double, etc. vs std::string, std::fstream, etc.), namely,
 *  non-primitive data types require the instantiation of a new instance using the "new" keyword
 *  and are passed-by-object-reference (i.e., changing parameter affects argument)
 */
public class VariableDeclarations {

	public static void main(String[] args) {
		
		
		// Primitives do not use the "new" keyword and are passed-by-value
		char    someChar   = 'a';
		int     someInt    = 7;
		double  someDouble = 19.0;
		boolean someBool   = false; 	// Equivalent to the bool data data from C++
		
		// Non-primitives generally require a "new" instantiation and are "passed-by-reference"
		String  str      = "Hello";					// Similar to std::string from C++
													// Strings are immutable...cannot use index to access..
		
		str.charAt(0);								// But the charAt method can be used for read-only access
		
		Scanner input    = new Scanner(System.in);	// Facilitates input from console input
													// Requires import java.util.Scanner
		
		StringBuilder sb = new StringBuilder();		// Creates strings piece-by-piece

		// Arrays are similar to C++
		int[] someArray;	// Can be declared for later initialization
		char[] anotherArray = new char[] {'a','p','p','l','e'};	// Cannot provide subscript if initial value is provided
		boolean[] yetAnotherArray = new boolean[25];
		
	}

}
