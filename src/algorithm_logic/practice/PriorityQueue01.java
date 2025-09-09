package algorithm_logic.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueue01 {
	public static void main(String[] args) {
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=1; i<10; i++) {
			minQueue.add(i);
			maxQueue.add(i);
		}
		System.out.println(minQueue);
		System.out.println(maxQueue);	//그냥 출력하면 같은 티어에 있는 노드가 나올 뿐, 순서를 보장하지 않음!!
		/*
		 * 출력값:
		 	[1, 2, 3, 4, 5, 6, 7, 8, 9]
			[9, 8, 6, 7, 3, 2, 5, 1, 4]
		 */
		
		//하나씩 삭제연산을 통해 루트노드를 출력하면 순서대로 나옴
		while(!maxQueue.isEmpty())
			System.out.print(maxQueue.poll() + " ");
		
		
		
	}

}
