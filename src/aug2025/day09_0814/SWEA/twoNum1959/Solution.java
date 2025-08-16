package aug2025.day09_0814.SWEA.twoNum1959;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day09_0814/SWEA/twoNum1959/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arrN = new int[N];
			int[] arrM = new int[M];
			
			for(int i = 0; i < N; i++) {
				arrN[i] = sc.nextInt();
			}
			for(int i = 0; i < M; i++) {
				arrM[i] = sc.nextInt();
			}
			
			int result = Integer.MIN_VALUE;  
			
			if(N > M) {
				result = multiplication(arrM, arrN);
			} else {
				result = multiplication(arrN, arrM);
			}
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}
	
	public static int multiplication(int[] shortArr, int[] longArr) {
		//1등을 기록하자 
		int max = 0;
		//짧은 배열의 탐색 범위 시작점  
		for(int i = 0; i <= longArr.length - shortArr.length; i++) {
			int result = 0;
			int index = 0;
			//짧은 배열길이만큼 전체 조회해서 곱하기 
			for(int j = i; j < i + shortArr.length; j++) {
				result += longArr[j] * shortArr[index++];
			}
			//최종값이 max보다 크다면
			if(result > max) {
				max = result;
			}
		}
		return max;
	}
	
}
