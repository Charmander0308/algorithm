package aug2025.weekend01_0809.baekjoon.basket10811;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] basket = new int[N];
		//바구니에 바구니 번호 담기 
		for(int i = 0; i < N; i++) {
			basket[i] = i + 1;
		}
		
		//값 받아서 그 사이의 값끼리 연산 
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int start = from - 1;
			int end = to - 1;
			
			//값은 중간까지만 스위칭 하면 다 바뀜 
			while(start < end) {
				int tmp = basket[start];
				basket[start] = basket[end];
				basket[end]= tmp;
				start++;
				end--;
			}
		}	
		
		//출력 
		for(int i = 0; i < N; i++) {
			System.out.print(basket[i]);
			if(i < N-1) {
				System.out.print(" ");
			}
		}
		sc.close();
	}

}
