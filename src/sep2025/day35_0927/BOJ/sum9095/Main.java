package sep2025.day35_0927.BOJ.sum9095;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dp = new int[11];	//n이 11보다 작음
		//초기세팅
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		//돌려돌려
		for(int i=4; i<11; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		for(int test_case = 1; test_case <=T; test_case++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}
