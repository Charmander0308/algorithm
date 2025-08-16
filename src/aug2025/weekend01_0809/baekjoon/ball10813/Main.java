package aug2025.weekend01_0809.baekjoon.ball10813;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		//바구니 
		int[] basket = new int[N];
		//번호에 맞게 공을 넣기 
		for(int i=0; i < N; i++) {
			basket[i] = i + 1;
		}
		//두 수를 받아서 해당 번호 바구니의 공을 교환 
		for(int i=0; i < M; i++) {
			int input1 = sc.nextInt();
			int input2 = sc.nextInt();
			
			int tmp = basket[input1 - 1];
			basket[input1 - 1] = basket[input2 - 1];
			basket[input2 - 1] = tmp;
		}
		//최종 결과 
		for(int i = 0; i < N; i++) {
			System.out.print(basket[i]);
			if(i < N-1) {
				System.out.print(" ");
			}
		}
		sc.close();
	}
}
