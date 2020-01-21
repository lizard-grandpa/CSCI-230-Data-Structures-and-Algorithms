package LabSolutions.JavaProgramming;

import java.util.ArrayList;
import java.util.Random;

public class Problem1_2 {

	private static ArrayList<String> bruteForceSolution(String str) {
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i < str.length(); ++i) {
			
			int leftLCount = 0;
			int leftRCount = 0;
			for(int j = 0; j < i; j++) {
				if(str.charAt(j) == 'L')      leftLCount++;
				else if(str.charAt(j) == 'R') leftRCount++;
			}
			
			if(i > 0 && leftLCount == leftRCount) list.add(str.substring(0, i));
			
			int rightLCount = 0;
			int rightRCount = 0;
			for(int j = i; j < str.length(); j++) {
				if(str.charAt(j) == 'L')      rightLCount++;
				else if(str.charAt(j) == 'R') rightRCount++;
			}
			
			if(i < str.length() && rightLCount == rightRCount) list.add(str.substring(i));
			
		}
		
		return list;
	}
	
	private static ArrayList<String> optimalSolution(String str) {
		
		ArrayList<String> list = new ArrayList<>();
		
		int lCount = 0;
		int rCount = 0;
		for(int i = 0; i < str.length(); ++i) {
			if(str.charAt(i) == 'L') lCount++;
			else if(str.charAt(i) == 'R') rCount++;
			if(lCount == rCount) list.add(str.substring(0,i+1));
		}
		
		lCount = 0;
		rCount = 0;
		for(int i = str.length() - 1; i >= 0; --i) {
			if(str.charAt(i) == 'L') lCount++;
			else if(str.charAt(i) == 'R') rCount++;
			if(lCount == rCount) list.add(str.substring(i));
		}
		
		return list;
	}
	
	private static String generateString() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		int sz = rand.nextInt(20);
		while(--sz >= 0) {
			if(rand.nextInt(2) == 0) sb.append('L');
			else sb.append('R');
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		String str = generateString();
		
		System.out.println("Sample String: " + str);
		System.out.print("BruteForce Solution: ");
		for(String s : bruteForceSolution(str)) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.print("Optimal Solution:    ");
		for(String s : optimalSolution(str)) {
			System.out.print(s + " ");
		}
		
	}
}
