package oct2025.day1011.BOJ.ballon2346;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ballons = new int[N];
		for(int i=0; i<N; i++) {
			ballons[i] = sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		int targetIdx = 0;
		int rest = N;
		for(int i=0; i<N; i++) {
			int now = 0;
			if(Math.abs(ballons[targetIdx]) < rest) {
				targetIdx = (N+ballons[targetIdx]) % N;
			}
			sb.append(targetIdx);
			rest--;
		}
		
		
	}

}
