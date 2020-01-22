package LectureNotes.JavaProgramming;

/*	This example illustrates the use of static and non-static members and how to access
 *  these members using an instantiated object.
 *  
 *  MANY Java classes use static member variables and functions. This is particularly useful
 *  when you want to perform an operation which belongs to a member of a class without needing
 *  to instantiate the class. A popular static method includes Character.toLowerCase(...).
 */
public class ObjectInstantiation {

	// Some private static members
	static int someMember;
	static void someFunction() {}
	
	// Some instance members
	char anotherMember;
	void anotherFunction() {}
	
	// An empty default constructor
	public ObjectInstantiation() {}
	
	// A main method in a class can be used to perform unit-testing for the class
	public static void main(String[] args) {
		
		// Access static members
		ObjectInstantiation.someMember = 10; // Fully qualified name useable anywhere in scope
		someFunction();	// Non-qualified name is possible since in the same class
		
		// Accessing instance members is only possible after instantiating the object
		ObjectInstantiation o = new ObjectInstantiation();
		o.anotherMember = 10;
		o.anotherFunction();
		
		// We can still access static members using an instance (since each instance shares
		// the static member) but a warning is given to us by Eclipse indicating we should
		// use the static method
		o.someMember = 10;
		
	}
}
