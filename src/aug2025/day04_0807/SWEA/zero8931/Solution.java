package aug2025.day04_0807.SWEA.zero8931;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day04_0807/SWEA/zero8931/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt();
			//항아리 1개
			Stack<Integer> stack = new Stack<>();
			
			//K번 넣거나 빼기
			for(int i = 0; i < K; i++) {
				int input = sc.nextInt();
				//0이 호출되면
				if(input == 0) {
					if(!stack.isEmpty()) {	//항아리가 비어있지 않으면 직전 값 빼기
						stack.pop();
					} else {	//비어있는데 더 빼려고하면
						System.out.println("뺄게없음");
						continue;
					}
				} else {	//그 외엔 스택 쌓기
					stack.push(input);
				}
			}
			//초기값은 0
			int ans = 0;
			while(!stack.isEmpty()) {	//비어있지 않다면 빌때까지 ans에 계속 더해주기
				ans += stack.pop();
			}
			//완성
			System.out.println("#" + test_case + " " + ans);
			
		}
		sc.close();
	}
}
