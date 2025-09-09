package sep2025.day19_0909.SWEA.disjoint3289;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] p;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day19_0909/SWEA/disjoint3289/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();

			int n = sc.nextInt();
			int m = sc.nextInt();
			p = new int[n+1];
			makeSet(n);
//			System.out.println(Arrays.toString(p));
			
			for(int i=0; i<m; i++) {
				int cal = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(cal == 0) union(a, b);
				else if(cal == 1) {
					int ans = checkSet(a, b);
					sb.append(ans);
				}
				
//				System.out.println(Arrays.toString(p));
			}
			System.out.println("#" + test_case + " " + sb);
		}
	}
	
	//배열만들기
	static void makeSet(int n) {
		for(int i=1; i<=n; i++) {
			p[i] = i;
		}
	}
	
	//루트찾기
	static int findSet(int x) {
		if(x == p[x]) return p[x];
		return p[x] = findSet(p[x]);
	}
	
	//0: 집합끼리 합치기
	static void union(int x, int y) {
		if(findSet(x) != findSet(y)) {
			p[findSet(y)] = findSet(x);
		}
	}
	
	//1: 같은 집합이면 1, 아니면 0 리턴
	static int checkSet(int x, int y) {
		if(findSet(x) == findSet(y)) return 1;
		else return 0;
	}
}
