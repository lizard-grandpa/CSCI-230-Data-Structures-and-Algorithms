package LabSolutions.ObjectOrientedProgramming;

public class IsocelesTriangle extends Triangle {

	IsocelesTriangle(Coordinate<Double>[] v) {
		super(v);
		
		if(!isIsoceles(v)) throw new IllegalArgumentException("Triangle is not isoceles!");
	}

	// At least two sides must have equal length for triangle to be considered isoceles
	private boolean isIsoceles(Coordinate<Double>[] v) {
		Double[] len = new Double[3];
		len[0] = Math.sqrt(Math.pow(v[0].getX() - v[1].getX(),2) + Math.pow(v[0].getY() - v[1].getY(),2));
		len[1] = Math.sqrt(Math.pow(v[1].getX() - v[2].getX(),2) + Math.pow(v[1].getY() - v[1].getY(),2));
		len[2] = Math.sqrt(Math.pow(v[2].getX() - v[0].getX(),2) + Math.pow(v[2].getY() - v[1].getY(),2));
		
		if(len[0].equals(len[1]) || len[0].equals(len[1]) || len[1].equals(len[2])) return true;
		else return false;
	}

}
