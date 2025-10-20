package oct2025.day01_1001.BOJ.ballon2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Ballon {
		int idx, score;
		public Ballon(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Deque<Integer> d = new ArrayDeque<>();
		Deque<Integer> idxQueue = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			d.add(Integer.parseInt(st.nextToken()));
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
//		for(int num : answer) {
//			System.out.print(num + " ");
//		}
		for(int i=0; i<N; i++) {
			System.out.print(answer.get(i));
			if(i<N-1) System.out.print(" ");
		}
		
	}
}
