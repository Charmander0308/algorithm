package aug2025.interlude07_0826.baekjoon.colored_paper2563;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] paper = new int[100][100];
		int area = 0;
		
		for(int i = 0 ; i < N; i++) {
			int input_r = sc.nextInt();
			int input_c = sc.nextInt();
			
			for(int r = input_r - 1; r < input_r - 1 + 10; r++) {
				for(int c = input_c - 1; c < input_c - 1 + 10; c++) {
					if(paper[r][c] == 0) {
						paper[r][c] = 1;
						area++;
					}
				}
			}
		}
		System.out.println(area);
		
	}

}
