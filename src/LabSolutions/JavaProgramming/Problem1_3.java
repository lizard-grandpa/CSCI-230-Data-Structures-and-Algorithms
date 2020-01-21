package LabSolutions.JavaProgramming;

/* Not Finished*/
import java.util.Arrays;
import java.util.Random;

public class Problem1_3 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int size = rand.nextInt() * 2;
		
		int[] arr = new int[size];
		for(int n : arr)
			n = rand.nextInt();


}
