package sep2025.day16_0903.SWEA.tree14510;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("src/sep2025/day16_0903/SWEA/tree14510/sample_input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(tree));
			Arrays.sort(tree);
			int goal = tree[N-1];
			int day = 0;
			int water = 0;
			while(true) {
				day++;
				if(day%2 != 0) water = 1;
				else water = 2;
				
				for(int i=0; i<N; i++) {
					if(goal-tree[i] >= water) {
						tree[i] += water;
						break;
					}
				}
				
				
			}
			
			
			
		}
		
	}

}
