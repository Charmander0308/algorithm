package sep2025.day0919.BOJ.max11279;

import java.util.Scanner;

public class Main {
	static int[] heap;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			heap = new int[N];
			if(num == 0) maxPrint();
			else addNum(num);
		}
		
		
	}

	private static void maxPrint() {
		if(heap[0] == 0) {
			System.out.println(0);
		}
		else {
			System.out.println(heap[0]);
		}
	}
	
	private static void addNum(int num) {
		if(heap[0] == 0) {
			
		}
		else {
			
		}
	}

}
