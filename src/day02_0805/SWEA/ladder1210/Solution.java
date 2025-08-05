package day02_0805.SWEA.ladder1210;

import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		File file = new File("src/day02_0805/SWEA/ladder1210/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = 10;
		
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		int[][] arr = new int[100][100];
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			int ans = 0;
			//값 받기
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			//델타 인엑스
			int index = 1;
			//시작 행
			int r = 99;
			//시작 열
			int c = 0;
			//2인 곳 찾아서 시작 위치 등록
			for(int i = 0; i < 100; i++) {
				if(arr[r][i]==2) c=i;
			}
			
			while(true) {
				//시작점이 arr[99][0]일때, c+dc[0]을 조회하면 Index -1 out of bounds for length 100 뜸,,,, 집가서 해결하기
				
				
				//주변을 둘러봐라
				//1. 상=1, 좌=0, 우=0 
				if(arr[r+dr[0]][c+dc[0]] == 0 && arr[r+dr[1]][c+dc[1]] == 1 && arr[r+dr[2]][c+dc[2]] == 0) {
					index = 1;
				//2. 상=1, 좌=1, 우=0
				} else if(arr[r+dr[0]][c+dc[0]] == 1 && arr[r+dr[1]][c+dc[1]] == 1 && arr[r+dr[2]][c+dc[2]] == 0) {
					if(index == 1) {
						index = 0;
					} else if(index == 2) {
						index = 1;
					}
				//3. 상=0, 좌=1, 우=1
				} else if(arr[r+dr[0]][c+dc[0]] == 0 && arr[r+dr[1]][c+dc[1]] == 1 && arr[r+dr[2]][c+dc[2]] == 1) {
					if(index == 1) {
						index = 2;
					} else if(index == 0) {
						index = 1;
					}
				//4. 상=1, 좌=0, 우=1
				} else if(arr[r+dr[0]][c+dc[0]] == 1 && arr[r+dr[1]][c+dc[1]] == 0 && arr[r+dr[2]][c+dc[2]] == 1) {
					if(index == 2) {
						index = 2;
					} else if(index == 0) {
						index = 0;
					}
				}
				//움직여라
				r += dr[index];
				c += dc[index];
				
				if(r == 0) {
					ans = c;
					break;
				}
			
			}
			
			
			System.out.println("#" + test_case + " " + ans);
			
			
		}
		
	}

}
