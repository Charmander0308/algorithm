package oct2025.day01_1001.BOJ.ballon2346;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> d = new ArrayDeque<>();
		Deque<Integer> idxQueue = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			d.add(sc.nextInt());
			idxQueue.add(i+1);
		}
		List<Integer> answer = new LinkedList<>();
		int getNum = d.pollFirst();
		answer.add(idxQueue.pollFirst());
		
		for(int i=1; i<N; i++) {
			if(getNum > 0) {
				for(int j=1; j<getNum; j++) {
					int tmp = d.pollFirst();
					int tmpNum = idxQueue.pollFirst();
					d.addLast(tmp);
					idxQueue.addLast(tmpNum);
				}
				getNum = d.pollFirst();
				answer.add(idxQueue.pollFirst());
			}
			else if(getNum < 0) {
				getNum = Math.abs(getNum);
				for(int j=1; j<getNum; j++) {
					int tmp = d.pollLast();
					int tmpNum = idxQueue.pollLast();
					d.addFirst(tmp);
					idxQueue.addFirst(tmpNum);
				}
				getNum = d.pollLast();
				answer.add(idxQueue.pollLast());
			}
		}
		for(int num : answer) {
			System.out.print(num + " ");
		}
		
	}
}
