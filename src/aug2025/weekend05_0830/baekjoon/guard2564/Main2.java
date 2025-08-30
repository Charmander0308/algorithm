package aug2025.weekend05_0830.baekjoon.guard2564;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();
		int N = sc.nextInt();
		int[] stores = new int[N];
		
		for(int i=0; i < N; i++) {
			int direction = sc.nextInt();
			int distance = sc.nextInt();
			stores[i] = location(direction, distance, width, height);
		}
		
		int DG_direction = sc.nextInt();
		int DG_distance = sc.nextInt();
		int DG_location = location(DG_direction, DG_distance, width, height);
		
		int answer = 0;
		for(int i=0; i < N; i++) {
			int case1 = Math.abs(DG_location - stores[i]);
			int case2 = (width + height) * 2 - case1;
			answer += Math.min(case1, case2);
		}
		System.out.println(answer);
	}
	
	//2차원 공간에서의 위치를 알아보자!
	public static int location(int direction, int distance, int width, int height) {
		switch(direction) {
		case 1:
			return distance;
		case 2:
			return width + height + (width - distance);
		case 3:
			return width * 2 + height + (height - distance);
		case 4:
			return width + distance;
		}
		return 0;
	}
}
