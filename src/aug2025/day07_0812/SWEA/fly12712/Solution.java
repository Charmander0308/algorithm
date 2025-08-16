package aug2025.day07_0812.SWEA.fly12712;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	//상, 우, 하, 좌, 좌상, 우상, 우하, 좌하
	static int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dc = {0, 1, 0, -1, -1, 1, 1, -1};

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day07_0812/SWEA/fly12712/in1.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] flyMap = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					flyMap[i][j] = sc.nextInt();
				}
			}
			//가장 많이 잡은 파리수
			int max = 0;
			//각 좌표를 분사지점으로 설정하고 분사 범위만큼 계산하여 잡은 파리 수 max랑 비교하기
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					//1. + 모양 (0~3)
					int sum = spray(flyMap, flyMap[r][c], 0, M, N, r, c);
					//최고기록인가요?
					max = Math.max(max, sum);
					//2. x 모양 (4~7)
					sum = spray(flyMap, flyMap[r][c], 4, M, N, r, c);
					//최고기록인가요?
					max = Math.max(max, sum);
				}
			}
			//출력
			System.out.println("#" + test_case + " " + max);
		}
		sc.close();
	}
	
	//잡은 파리수 리턴하는 함수
	public static int spray(int[][] flyMap, int point, int shape, int M, int N, int r, int c) {
		//분사지점값 미리 넣어두기
		int sum = point;

		//특정방향으로 M 범위만큼 쏘기
		for(int i = shape; i < shape + 4; i++) {
			for(int j = 1; j < M; j++) {
				int nextR = r + (dr[i] * j);
				int nextC = c + (dc[i] * j);
				
				if(nextR >= 0 && nextR < N && nextC >= 0 && nextC <N) {
					sum += flyMap[nextR][nextC];
				}
			}
		}
		return sum;
	}
}
