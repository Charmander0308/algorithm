package weekend01_0809.baekjoon.homework5597;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//학생은 30번까지 
		int[] arr = new int[30];
		//낸 사람은 28명, 제출한 사람의 번호-1 인덱스를 1로 바꿈 
		for(int i = 0; i < 28; i++) {
			int input = sc.nextInt();
			arr[input-1] = 1;
		}
		//0인 인덱스+1 번 학생은 미제출 
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]==0) {
				System.out.println(i+1);
			}
		}
		sc.close();
	}
}
