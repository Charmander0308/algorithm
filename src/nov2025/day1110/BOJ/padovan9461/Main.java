package nov2025.day1110.BOJ.padovan9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] numList = new long[101];
		numList[1] = 1; 
		numList[2] = 1; 
		
		for(int i=3; i<=100; i++) {
			numList[i] = numList[i-3] + numList[i-2];
		}
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(numList[N]);
			
		}
		
	}
}
