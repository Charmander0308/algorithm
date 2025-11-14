package btypeprep.week1.no1_insomnia;

import java.util.Scanner;

public class Solution {
	static boolean[] isVisited;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int k = 1;
			isVisited = new boolean[10];
			cnt = 0;
			while(cnt < 10) {
				long num = N*k;
				function(num);
				k++;
			}
			System.out.println("#" + test_case + " " + N*(k-1));
		}
	}

	private static void function(long num) {
		int n = (int)num % 10;
		if(isVisited[n] == false) {
			isVisited[n] = true;
			cnt++;
		}
		
		if(num < 10) return;
		
		function(num / 10);
	}
	
	
}
