package aug2025.day06_0811.SWEA.password1225;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day06_0811/SWEA/password1225/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			//큐에 값 8개 저장 
			Queue<Integer> q = new LinkedList<>();
			for(int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			// 감소 폭 
			int count = 1;
			//0보다 작아지는 경우 0으로 유지시키며 종료 
			while(true) {
				//감소한 값을 저장 
				int result = q.poll() - count;
				//0보다 작다면 마지막에 0을 삽입하고 반복 종료 
				if(result <= 0) {
					q.offer(0);
					break;
				}
				//저장한 값을 다시 추가 
				q.offer(result);
				//감소 값 1증가 + 5 초과 시 다시 1로 회귀 
				count++;
				if(count > 5) count = 1;
			}
			//출력 
			System.out.print("#" + test_case);
			while(!q.isEmpty()) {
				System.out.print(" " + q.poll());
			}
			System.out.println();
			
		}
	}
}
