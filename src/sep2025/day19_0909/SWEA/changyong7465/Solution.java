package sep2025.day19_0909.SWEA.changyong7465;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		File file = new File("src/sep2025/day19_0909/SWEA/changyong7465/s_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			makeSet(N);
			
			for(int i=0; i<M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				union(x, y);
			}
			System.out.println(Arrays.toString(p));
			
			Set<Integer> s = new HashSet<>();
			for(int i=1; i<=N; i++) {
				s.add(findSet(p[i]));
			}
			System.out.println("#" + test_case + " " + s.size());
			
		}
		
	}
	
	static void makeSet(int n) {
		p = new int[n+1];
		for(int i=1; i<=n; i++) {
			p[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(x == p[x]) return p[x];
		return p[x] = findSet(p[x]);
	}
	
	static void union(int x, int y) {
		int rx = findSet(x);
		int ry = findSet(y);
		
		if(rx != ry)
			p[ry] = rx;
	}
	
}
