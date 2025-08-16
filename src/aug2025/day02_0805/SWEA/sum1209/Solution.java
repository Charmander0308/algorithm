package aug2025.day02_0805.SWEA.sum1209;

import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		File file = new File("src/day02_0805/SWEA/sum1209/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			
			//배열 입력받기
			int[][] arr = new int[100][100];
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int maxR = 0;	//가장 큰 행의 합
			int maxC = 0;	//가장 큰 열의 합
			
			int totalD = 0;		//대각선 정방향
			int totalDR = 0;	//대각선 역방향
			
			//배열 순회
			for(int i = 0; i < 100; i++) {
				int totalR = 0;
				int totalC = 0;

				//행 열마다 100개씩 다 더해서 담기
				for(int j = 0; j < 100; j++) {
					totalR += arr[i][j];
					totalC += arr[j][i];
				}
				
				//행과 열의 최대값 도출
				if(totalR > maxR) {
					maxR = totalR;
				}
				if(totalC > maxC) {
					maxC = totalC;
				}
				//대각선 두개 각 총합 구하기
				totalD += arr[i][i];
				totalDR += arr[i][99-i];
			}
			//가장 큰 케이스 도출
			int[] forAns = {totalD, totalDR, maxR, maxC};
			int ans = forAns[0];
			for(int i = 1; i < forAns.length; i++) {
				if(forAns[i] > ans) {
					ans = forAns[i];
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
		
	}

}
