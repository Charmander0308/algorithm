package day01_0804.SWEA.average1984;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		File file = new File("./src/day01_0804/SWEA/average1984/input.txt");
		Scanner sc = new Scanner(file);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;

			// 값 받아오기
			int[] numArr = new int[10];
			for (int i = 0; i < 10; i++) {
				numArr[i] = sc.nextInt();
			}

			// 평균 구할때 쓸 총 합
			int sum = 0;
			// 순차정렬
			Arrays.sort(numArr);
			// 앞뒤 하나씩 빼고 다 더하기
			for (int i = 1; i < numArr.length - 1; i++) {
				sum += numArr[i];
			}
			// 평균 구하기
			ans = sum / (numArr.length - 2);

			System.out.println("#" + test_case + " " + ans);
		}
	}

}
