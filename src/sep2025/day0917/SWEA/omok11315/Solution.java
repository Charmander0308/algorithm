package sep2025.day0917.SWEA.omok11315;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static String [][] arr;
	static int N;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day24_0916/SWEA/question7087/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			
			arr = new String[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.next();
				}
			}
			
			
			
		}
	}
	
	static void dfs(int r, int c) {
		if(arr[r][c].equals(".")) {
			dfs(r, c+1);
			if(c == N) {
				dfs(r, c);
			}
			return;
		}
		
	}
	
}
