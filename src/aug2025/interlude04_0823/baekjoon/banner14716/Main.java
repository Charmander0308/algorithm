package aug2025.interlude04_0823.baekjoon.banner14716;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] banner = new int[M][N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				banner[i][j] = sc.nextInt();
			}
		}
		int width = 0;
		for(int i=0; i<M; i++) {
			boolean isLine = true;
			for(int j=0; j<N; j++) {
				if(banner[i][j] == 1) {
					isLine = false;
					break;
				}
			}
			if(isLine == true) {
				width++;
			}
		}
		int height = 0;
		for(int i=0; i<N; i++) {
			boolean isLine = true;
			for(int j=0; j<M; j++) {
				if(banner[j][i] == 1) {
					isLine = false;
					break;
				}
			}
			if(isLine == true) {
				height++;
			}
		}
		int answer = (width-1)*(height-1);
		System.out.println(answer);
	}

}
