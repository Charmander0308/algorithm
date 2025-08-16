package aug2025.day06_0811.SWEA.joonhong7102;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day06_0811/SWEA/joonhong7102/sample_input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			//경우의 수 값들을 담을 큐 생성 
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					q.offer(i+j);
				}
			}
			//숫자별 기록용 
			int[] arr = new int[N + M];
			int max = 0;
			//다 꺼내면서 숫자 카운트 
			while(!q.isEmpty()) {
				arr[q.poll()-1]++;
			}
			//최대값 찾기 
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] > max) {
					max = i + 1;
				}
			}
			//출력 
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == max) {
					System.out.print((i + 1) + " ");
				}
			}
			System.out.println();
			
		}
		sc.close();
	}
}
