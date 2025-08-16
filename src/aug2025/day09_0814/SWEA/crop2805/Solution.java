package aug2025.day09_0814.SWEA.crop2805;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day09_0814/SWEA/crop2805/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
//		int T = 1;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			sc.nextLine();
			
			int center = N/2;
			int[][] farm = new int[N][N];
			
			//숫자가 띄어쓰기가 없네요
			for(int i = 0; i < N; i++) {
				String line = sc.nextLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = line.charAt(j) -'0';
				}
			}
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(farm[i][j] + " ");
//				}
//				System.out.println();
//			}
			//농장 사이즈 별 수확 가능 범위(ex: N=5일때 가능한 범위는 중심기준 2칸까지) 
			int harvest = (N+1)/2-1;
			//총 수확물 저장 
			int total = 0;
			//각 좌표별 중심 좌표에서 얼마나 떨어져있는지 절대값을 구하고, 그 값이 harvest이하면 수확 가능하므로 total에 추가 
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int moveR = Math.abs(i - center);
					int moveC = Math.abs(j - center);
					if(moveR + moveC <= harvest) {
						total += farm[i][j];
					}
//					System.out.println(i + "," +j + "=" +total);
				}
			}
			//출력 
			System.out.println("#" + test_case + " " + total);
		}//test_case End 
		sc.close();
	}
	
}
