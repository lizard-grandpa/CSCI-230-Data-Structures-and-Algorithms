package LabSolutions.JavaProgramming;

import java.util.Random;

public class Problem1_1 {

	private static int SumIterative(int n) {
		
		int total = 0;
		do {total += n % 10;}
		while((n /= 10) != 0);
		return total;
	}
	
	private static int ProductRecursive(int n) {
			if(n == 0) return 1;
			return (n % 10) * ProductRecursive(n / 10);
		}
		
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		int n = rand.nextInt();
		System.out.println("Number: " + n);
		System.out.println("SumIterative: " + SumIterative(n));
		System.out.println("ProductRecursive: " + ProductRecursive(n));

	}

}
