package aug2025.interlude08_0827.baekjoon.chess1018;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		String[][] area = new String[N][M];
		for(int i=0; i<N; i++) {
			String line = sc.next();
			for(int j=0; j<M; j++) {
				area[i][j] = String.valueOf(line.charAt(j));
			}
		}
		int min = 64;
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				int changeForWStart = 0;
				for(int r=i; r<i+8; r++) {
					for(int c=j; c<j+8; c++) {
						if((r+c)%2==0) {
							if(!area[r][c].equals("W")) {
								changeForWStart++;
							}
						} else {
							if(!area[r][c].equals("B")) {
								changeForWStart++;
							}
						}
					}
				}
				int changeForBStart = 64-changeForWStart;
				int change = Math.min(changeForWStart, changeForBStart);
				if(change < min) min = change;
			}
		}
		System.out.println(min);
	}
}
