package aug2025.day04_0807.baekjoon.chess3003;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//기본셋(킹, 퀸, 룩, 비숍, 나이트, 폰)
		int[] arr = {1, 1, 2, 2, 2, 8};
		
		//6개 갯수 입력받아서 비교하면서 차이 출력하기
		for(int i = 0; i < arr.length; i++) {
			int num = sc.nextInt();
			System.out.print(arr[i] - num);
			if(i != arr.length-1) {
				System.out.print(" ");
			}
		}
		sc.close();
	}
}
