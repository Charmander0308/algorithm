package sep2025.day33_0925.BOJ.card1715;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = sc.nextInt();

		for(int i=0; i<N; i++) {
			pq.offer(sc.nextInt());
		}
		int ans = 0;
		while(pq.size() > 1) {
			int cnt = pq.poll() + pq.poll();
			ans += cnt;
			pq.offer(cnt);
		}
		System.out.println(ans);
	}
}
