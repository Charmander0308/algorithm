package btypeprep.week1.no2_binary;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			boolean b = true;
			
			for(int i=0; i<N; i++) {
				if((M & (1<<i)) == 0) {
					b = false;
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + (b ? "ON" : "OFF"));
			
		}
	}
}
