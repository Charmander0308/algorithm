package sep2025.weekend10_0914.BOJ.nm15649;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static boolean[] checked;
	static int[] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		checked = new boolean[N+1];
		ans = new int[M];
		
		bt(0);
		
		
	}

	private static void bt(int num) {
		if(num == M) {
			for(int i : ans) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!checked[i]) {
				checked[i] = true;
				ans[num] = i;
				
				bt(num+1);
				
				checked[i] = false;
			}
		}
	}
}
