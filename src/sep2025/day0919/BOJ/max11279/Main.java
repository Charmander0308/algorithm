package sep2025.day0919.BOJ.max11279;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		pq = new PriorityQueue<>(Collections.reverseOrder());
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			//0이면 출력
			if(num == 0) maxPrint();
			//자연수면 힙에 저장
			else pq.add(num);
		}
		
	}

	private static void maxPrint() {
		if(pq.isEmpty()) {
			System.out.println(0);
		}
		else {
			System.out.println(pq.poll());
		}
	}
}
