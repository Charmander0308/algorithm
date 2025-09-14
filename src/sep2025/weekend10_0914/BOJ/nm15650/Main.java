package sep2025.weekend10_0914.BOJ.nm15650;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] ans;
	static boolean[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = new int[M];
		check = new boolean[N+1];
		
		bt(1, 0);
		
		
	}

	private static void bt(int num, int depth) {
		if(depth == M) {
			for(int i : ans) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=num; i<N+1; i++) {
			if(!check[i]) {
				ans[depth] = i;
				check[i] = true;
				
				bt(i+1, depth+1);
				
				check[i] = false;
			}
		}
		
	} 

}
