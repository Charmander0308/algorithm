package day06_0811.SWEA.joonhong7102;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day06_0811/SWEA/joonhong7102/sample_input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					q.offer(i+j);
				}
			}
			int[] arr = new int[N + M];
			int max = 0;
			while(!q.isEmpty()) {
				if(arr[q.peek()-1] > max) max = arr[q.peek()-1];
				arr[q.poll()-1]++;
			}
			
//			System.out.println(Arrays.toString(arr));
			
			
			
			
			
			
			
			
		}
		sc.close();
	}
}
