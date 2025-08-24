package aug2025.interlude05_0824.baekjoon.cake3985;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] cake = new int[L];
		int estimate = 0;
		int estimateNo = 0;
		int result = 0;
		int resultNo = 0;
		
		for(int i=1; i <= N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			if(end-start+1 > estimate) {
				estimate = end-start+1;
				estimateNo = i;
			}
			
			for(int j=0; j < L; j++) {
				if(j >= start-1 && j <= end-1 && cake[j]==0) {
					cake[j] = i;
				}
			}
		}
		
		for(int i=1; i <= N; i++) {
			int cnt = 0;
			for(int j = 0; j<L; j++) {
				if(cake[j]==i) cnt++;
			}
			if(cnt > result) {
				result = cnt;
				resultNo = i;
			}
		}
		
		System.out.println(estimateNo);
		System.out.println(resultNo);
		
		
		
	}

}
