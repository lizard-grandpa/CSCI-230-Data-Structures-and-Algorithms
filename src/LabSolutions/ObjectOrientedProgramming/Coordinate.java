package LabSolutions.ObjectOrientedProgramming;

public class Coordinate<T> {

	private T x, y;
	
	// To-Do: Figure out how to call default constructor for a template variable (i.e. T())
	// The C++ equivalent would be public Coordinate() : Coordinate(T(), T()) {} Based on
	// it does not seem we can do this "https://stackoverflow.com/questions/75175/create-instance-of-generic-type-in-java"
	// +1 Point Extra Credit for anyone who finds the answer
	
	public Coordinate() {
		// x = Class<T>();
		// y = Class<T>();

	}
	
	public Coordinate(T x, T y) { 
		this.x = x;
		this.y = y;
	}
	
	public T getX() { return x; }
	public T getY() { return y; }
	
	@Override
	public String toString() { return "(" + x + ", " + y + ")"; }
	
	public boolean equals(Coordinate<T> c) {
		return this.x == c.x && this.y == c.y;
	}
	
}
