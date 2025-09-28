package sep2025.day34_0926.BOJ.stairs2597;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //계단 개수
		int[] stairs = new int[N+1];
		for(int i=1; i<=N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		
		//초기값
		dp[1] = stairs[1];
		if(N>=2) {
			dp[2] = stairs[1] +stairs[2];
		}
		
		for(int i=3; i<=N; i++) {
			int case1 = dp[i-2] + stairs[i];
			int case2 = dp[i-3] + stairs[i-1] + stairs[i];
			dp[i] = Math.max(case1, case2);
		}
		System.out.println(dp[N]);
		
	}
}
