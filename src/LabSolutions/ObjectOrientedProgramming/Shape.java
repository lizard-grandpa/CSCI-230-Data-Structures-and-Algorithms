package LabSolutions.ObjectOrientedProgramming;

/**
 *  It is intended for all shapes to extend class Shape
 */
public class Shape implements Polygon{

	protected Coordinate<Double>[] vertices;
	
	Shape(Coordinate<Double>[] v) {
		vertices = v.clone();
		
		for(int i = 0; i < v.length; ++i)
			for(int j = 0; i < v.length; ++j) {
				if(i == j) continue;
				if(v[i].equals(v[j])) throw new IllegalArgumentException("Points must be unique");
			}
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Points: ");
		for(Object o : vertices)
			sb.append(o.toString() + " ");
		return sb.toString();
	}
	
	/**
	 * Implementation of the area finding equation found at https://www.mathopenref.com/coordpolygonarea.html does not work
	 * on polygons whose sides cross.
	 */
	@Override
	public double area() {
		double ret = 0;
		int i;
		for(i = 0; i < vertices.length - 1; ++i) {
			ret += vertices[i].getX()*vertices[i+1].getY();
			ret -= vertices[i].getY()*vertices[i+1].getX();
		}
		ret += vertices[i].getX()*vertices[0].getY();
		ret -= vertices[i].getY()*vertices[0].getX();
		
		return Math.abs(ret / 2);
		
	}
	
	@Override
	public double perimeter() {
		
		double ret = 0;
		int i;
		for(i = 0; i < vertices.length - 1; ++i) {
			ret += Math.sqrt(Math.pow(vertices[i].getX() - vertices[i+1].getX(),2) + Math.pow(vertices[i].getY() - vertices[i+1].getY(),2));
		}
		ret += Math.sqrt(Math.pow(vertices[i].getX() - vertices[0].getX(),2) + Math.pow(vertices[i].getY() - vertices[0].getY(),2));
		
		return ret;
		
	}
}
