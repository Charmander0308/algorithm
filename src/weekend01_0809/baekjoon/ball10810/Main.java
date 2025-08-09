package weekend01_0809.baekjoon.ball10810;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//바구니 개수 
		int N = sc.nextInt();
		//공 넣을 횟수 
		int M = sc.nextInt();
		//바구니들 (1번 바구니 = 인덱스 0) 
		int[] basket = new int[N];
		//M만큼 공을 넣어보자 
		for(int i = 0; i < M; i++) {
			//from번 바구니부터 
			int from = sc.nextInt();
			//to번 바구니까지 넣자 
			int to = sc.nextInt();
			//넣을 공 번호 
			int ballNum = sc.nextInt();
			
			//from번 부터 to번 까지 공 번호 갱신 
			for(int j = from; j <= to; j++) {
				basket[j-1] = ballNum;
			}
		}
		//들어있는 공번호를 출력 
		for(int i = 0; i < N; i++) {
			System.out.print(basket[i]);
			if(i < N-1) {
				System.out.print(" ");
			}
		}
		sc.close();
	}

}
