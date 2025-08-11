package algorithm_logic.test0811;

import java.util.Arrays;
import java.util.Scanner;

public class Algo3_서울_13_한예성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 상,우,하,좌,좌상,우상,우하,좌하
		int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
		int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int stoneR = sc.nextInt();
			int stoneC = sc.nextInt();
			int weight = sc.nextInt();
			int power = sc.nextInt();

			int[][] arr = new int[N][N];
			//처음 돌 던지는 위치의 값 넣기
			arr[stoneR-1][stoneC-1] = weight;
			
			//각 라인마다 8방에 해당하는 위치에 값 연산하여 넣기
			for (int i = 0; i < 8; i++) {
				//몇 칸 밖인지를 곱해준다
				for (int step = 1; step <= 10; step++) {
					int nextR = (stoneR-1) + dr[i] * step;
					int nextC = (stoneC-1) + dc[i] * step;
					
					if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
						//힘 * 칸넘버 + 최초무게
						int num = power * step + weight;
						//행과 열 양쪽 범위를 1씩 늘려서 값을 넣기
						for(int r = stoneR-1-step; r <= stoneR-1+step; r++) {
							for(int c = stoneC-1-step; c <= stoneC-1+step; c++) {
								//범위 안전 확인
								if(r >= 0 && r < N && c >= 0 && c < N) {
									//이미 값이 있으면 생략
									if(arr[r][c] != 0) {
										continue;
									}
									//0미만 값이면 0으로 변경해서 넣기
									if(num <= 0) {
										num = 0;
									}
									arr[r][c] = num;
								}
							}
						}
					}
				}
			}
			
			//다 더한 값을 출력
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					answer += arr[i][j];
//					System.out.print(arr[i][j] + " ");
				}
//				System.out.println();
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
