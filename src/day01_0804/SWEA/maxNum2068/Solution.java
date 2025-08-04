package day01_0804.SWEA.maxNum2068;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		File file = new File("./src/day01_0804/SWEA/maxNum2068/input.txt");
		Scanner sc = new Scanner(file);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			
			// 값 받아오기
			int[] numArr = new int[10];
			for (int i = 0; i < 10; i++) {
				numArr[i] = sc.nextInt();
			}
			//순차 정렬해서 젤 마지막 값이 정답
			Arrays.sort(numArr);
			ans = numArr[numArr.length-1];
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}