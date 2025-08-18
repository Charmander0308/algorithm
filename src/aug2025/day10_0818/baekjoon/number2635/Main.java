package aug2025.day10_0818.baekjoon.number2635;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int max = 0;
		int idx = 0;
		//받은 수까지 돌려보기
		for(int i = 1; i <= input; i++) {
			int num1 = input;
			int num2 = i;
			int count = 1;
			
			//빼는 수가 0보다 크면 계속 반복하며 카운트하기
			while(num2 >= 0) {
				int tmp = num1;
				num1 = num2;
				num2 = tmp - num2;
				count++;
			}
			//최고기록이면 저장
			if(count > max) {
				max = count;
				idx = i;
			}
//			System.out.println(i + "로 빼는 경우=" + max);
		} //for문의 끝
		
		int num1 = input;
		int num2 = idx;
		
		//출력
		System.out.println(max);
		
		while(num2 >= 0) {
			System.out.print(num1 + " ");
			
			int tmp = num1;
			num1 = num2;
			num2 = tmp - num2;
		}
		//마지막 반복이면 남은 num1값 한번 더 출력
		System.out.println(num1);
		
	}

}
