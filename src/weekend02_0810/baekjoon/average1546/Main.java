package weekend02_0810.baekjoon.average1546;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//점수 받기
		int[] arr = new int[sc.nextInt()];
		//최댓값 저장
		double max = 0;
		//최댓값 찾기 + 배열에 점수 저장하기
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		//더한 값 저장용
		double sum = 0;
		//주어진 공식으로 계산해서 값 저장
		for(int i = 0; i < arr.length; i++) {
			sum += (double)(arr[i]/max)*100;
		}
		//평균 출력
		System.out.printf("%.6f", sum/arr.length);
		sc.close();
	}
}
