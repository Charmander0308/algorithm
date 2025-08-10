package day02_0805.SWEA.ladder1210;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		File file = new File("src/day02_0805/SWEA/ladder1210/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = 10;
		// 0: 좌, 1: 상, 2: 우
		int[] dr = {0, -1, 0};
		int[] dc = {-1, 0, 1};
		int[][] arr = new int[100][100];
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			int ans = 0;
			int r = 0;
			int c = 0;
			int delta = 1;
			//값 받기
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					//값이 2인 위치 = 시작점이니 해당 위치의 r과 c를 저장
					if(arr[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}
			//한칸씩 가보자
			
			while(r > 0) {
				if(c > 0 && arr[r][c-1] == 1) {
					c--;
				} else if(c > 0 && arr[r][c+1] == 1) {
					c++;
				} else {
					r--;
				}
			}
			
			ans = c;
			
			
			
			
			System.out.println("#" + test_case + " " + ans);
			
			
		}
		
		
		
	}

}
