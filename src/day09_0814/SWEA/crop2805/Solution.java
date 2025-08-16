package day09_0814.SWEA.crop2805;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day09_0814/SWEA/crop2805/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			sc.nextLine();
			
			int center = N/2+1;
			int[][] farm = new int[N][N];
			
			//숫자가 띄어쓰기가 없네요
			for(int i = 0; i < N; i++) {
				String line = sc.nextLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = line.charAt(j) -'0';
				}
			}
			
			
			
					
			
			
			
			
		}
		sc.close();
	}
	
}
