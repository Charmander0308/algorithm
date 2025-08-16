package aug2025.day06_0811.SWEA.perfect3499;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day06_0811/SWEA/perfect3499/sample_input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			//초기값을 큐에 넣어두자 
			Queue<String> q = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				q.offer(sc.next());
			}
			//반씩 나눠 받을 큐 두개를 만들자 
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			//절반은 q1, 나머지 반은 q2에 넣는다. 홀수면 q1에 하나 더 많이 넣는다.
			for(int i = 0; i < N; i++) {
				if(i < ((N+1)/2)) {
					q1.offer(q.poll());
				} else {
					q2.offer(q.poll());
				}
			}
			
			//번갈아가면서 꺼내어 출력한다 
			System.out.print("#" + test_case + " "); 
			for(int i = 0; i < N; i++) {
				if(i % 2 == 0) {
					System.out.print(q1.poll());
				} else {
					System.out.print(q2.poll());
				}
				if(i < N-1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
