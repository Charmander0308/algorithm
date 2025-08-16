package aug2025.day02_0805.SWEA.flatten1208;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		File file = new File("src/day02_0805/SWEA/flatten1208/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			int dump = sc.nextInt();
			int[] arr = new int[100];
			//넣기
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			//덤프횟수만큼 평탄화 하기
			for(int i = 1; i <= dump; i++) {
				//정렬(인덱스 0과 99에 자동으로 최저점과 최고점이 들어감) 
				Arrays.sort(arr);
				
				//이미 완료시 반복문 탈출
				if(arr[99] - arr[0] <= 1) {
					break;
				}
				//평탄화
				arr[0]++;
				arr[99]--;
				//평탄화 후 재정렬
				Arrays.sort(arr);
			}
			//고저차 반환
			ans = arr[99]-arr[0];
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
