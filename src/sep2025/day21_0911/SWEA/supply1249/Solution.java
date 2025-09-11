package sep2025.day21_0911.SWEA.supply1249;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int INF = Integer.MAX_VALUE;
	
	static class Location {
		int r, c;

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day21_0911/SWEA/supply1249/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] dist = new int[N][N];
			
			for(int i=0; i<N; i++) {
				Arrays.fill(dist[i], INF);
			}
			
			dist[0][0] = 0;
			
//			while() {
//				
//			}
		}
		
	}
	
}
