package algorithm_logic.test0811;

import java.util.Scanner;

public class Algo2_서울_13_한예성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		//상,우,하,좌,좌상,우상,우하,좌하
		int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1}; 
		int[] dc = {0, 1, 0 ,-1, -1, 1, 1, -1};
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			//입력받기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//모든게 웅덩이라고 가정
			boolean isOk = true;
			//확인된 웅덩이 개수
			int count = 0;
			//한 칸씩 탐색
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					//현재 위치
					int whole = arr[r][c];
					//8방탐색
					for(int k = 0; k < 8; k++) {
						int nextR = r + dr[k];
						int nextC = c + dc[k];
						
						//배열 범위 안에 있는 주위 1칸 탐색하고, 현재위치 값보다 작은 값이 있으면 false 후 탐색 종료
						if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
							if(whole > arr[nextR][nextC]) {
								isOk = false;
								break;
							}
						}
					}
					
					//나온 값의 상태가 true면 웅덩이 1 추가
					if(isOk == true) {
						count++;
					} else {
						//아니면 isOk만 true로 변경
						isOk = true;
					}
					
				}
			}
			
			System.out.println("#" + test_case + " " + count);
			
		}
		
	}
}
