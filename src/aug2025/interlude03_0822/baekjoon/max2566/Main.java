package aug2025.interlude03_0822.baekjoon.max2566;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];
		int max = 0, maxR = 0, maxC = 0;
		for(int i=0; i < 9; i++) {
			for(int j=0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] > max) {
					max = arr[i][j];
					maxR = i;
					maxC = j;
				}
			}
		}
		System.out.println(max);
		System.out.println((maxR+1) + " " + (maxC+1));
		
	}

}
