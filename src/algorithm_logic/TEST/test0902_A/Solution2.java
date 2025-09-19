package algorithm_logic.TEST.test0902_A;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			List<Integer> ballons = new LinkedList<>();
			for(int i=0; i<N; i++) {
				ballons.add(sc.nextInt());
			}
			answer = 0;
			function(ballons, N, 0);
			
			System.out.println("#" + test_case + " " + answer);
			
		}
		
	}
	
	static void function(List<Integer> list, int N, int score) {
		//종료
		if(N == 1) {
			score += list.get(0); 
//			System.out.println(score);
			if(score > answer) answer = score;
		}
		//재귀
		for(int i=0; i<N; i++) {
			int front = 0, back = 0;
			if(i == 0) {
				front = 1;
			} else {
				front = list.get(i-1);
			}
			if(i == N-1) {
				back = 1;
			} else {
				back = list.get(i+1);
			}
			int tar = list.get(i);
			int curScore = front * back;
			list.remove(i);
			function(list, N-1, score + curScore);
			list.add(i, tar);
		}
		
	}
	
}
