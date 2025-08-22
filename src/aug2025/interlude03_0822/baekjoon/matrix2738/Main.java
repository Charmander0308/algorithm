package aug2025.interlude03_0822.baekjoon.matrix2738;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] matrix_A = new int[N][M];
		int[][] matrix_B = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				matrix_A[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				matrix_B[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				matrix_B[i][j] += matrix_A[i][j];
				System.out.print(matrix_B[i][j]);
				
				if(j < M-1) System.out.print(" ");
			}
			System.out.println();
		}
		
	}

}
