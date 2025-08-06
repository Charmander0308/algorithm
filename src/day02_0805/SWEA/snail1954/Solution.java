package day02_0805.SWEA.snail1954;

import java.util.Scanner;

public class Solution {
	//0:우, 1:하, 2:좌, 3:상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			//시작점의 가로세로 좌표
			int d = 0;
			int c = 0;
			//시작방향 = 우
			int index = 0;
			//N x N 사이즈 달팽이
			int N = sc.nextInt();
			//한줄당 작성 가능한 숫자 수
			int line = N;
			//숫자 넣을때마다 세기
			int moveCount = 0;
			
			int[][] arr = new int[N][N];
			
			//사이즈만큼 돌자
			for(int i = 0; i < Math.pow(N, 2); i++) {
				//숫자 넣자
				arr[d][c] = i+1;
				//이동횟수 세자
				moveCount++;
				
				//지금까지 넣은 갯수가 한줄당 작성 가능한 숫자 수만큼 되면 
				if(moveCount == line) {
					//현재 방향이 0이나 2인덱스의 방향(우,좌)라면 다음 line이 1줄어듦
					if(index % 2 == 0) {
						line--;
					}
					//델타 인덱스 1씩 늘리고, 4가되면 다시 0으로 자동 대입
					index = (index+1) % 4;
					//이동횟수 초기화
					moveCount = 0;
				}
				//인덱스 방향으로 이동~
				d = d + dr[index];
				c = c + dc[index];
			}
			
			//정답 출력
			System.out.println("#" + test_case);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
