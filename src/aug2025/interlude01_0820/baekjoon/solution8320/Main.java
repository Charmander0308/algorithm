package aug2025.interlude01_0820.baekjoon.solution8320;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		for(int i=1; i<=n; i++) {
			count++;
			for(int j = 2; j < i; j++) {
				if(i % j == 0 && i >= j*j) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
