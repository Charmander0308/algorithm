package aug2025.day05_0808.baekjoon.count10807;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//처음 입력받는 값은 배열의 길이
		int[] arr = new int[sc.nextInt()];
		//두번째 입력받는 값은 배열의 원소들
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		//세번째 입력받는 값은 찾으려는 정수
		int checkNum = sc.nextInt();
		//찾은 개수 저장용
		int count = 0;
		//배열 순회하면서 일치하는 값을 찾을 때마다 개수 세기
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == checkNum) count++;
		}
		//정답 출력
		System.out.println(count);
		sc.close();
	}
}
