package LabSolutions.ObjectOrientedProgramming;

public class Triangle extends Shape {

	Triangle(Coordinate<Double>[] v) {
		super(v);
		if(v.length != 3) throw new IllegalArgumentException("Shape must have 3 unique points!");
	}

}
