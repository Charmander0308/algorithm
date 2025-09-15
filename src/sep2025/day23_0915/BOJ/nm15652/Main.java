package sep2025.day23_0915.BOJ.nm15652;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N+1];
		for(int i = 0; i <= N; i++) {
			arr[i] = i;
		}
		ans = new int[M];
		bt(0, 0);
		
	}
	
	static void bt(int num, int idx) {
		if(idx == M) {
			for(int i : ans) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(num>0 && ans[num-1] > i) continue;
			
			ans[num] = i;
			bt(num+1, idx+1);
		}
	}
}
