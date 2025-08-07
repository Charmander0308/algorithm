package day04_0807.SWEA.ironRod5432;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day04_0807/SWEA/ironRod5432/sample_input.txt");
		Scanner sc = new Scanner(file);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String input = sc.next();
			int total = 0;
			// 막대 수 스택 쌓기
			Stack<Integer> iron = new Stack<>();

			for (int i = 0; i < input.length(); i++) {
				// 여는 괄호면 일단 스택 하나 쌓기
				if (input.charAt(i) == '(') {
					iron.push(1);
				} else if (input.charAt(i) == ')') {
					// 닫는 괄호면 스택 하나 빼기(레이저거나 막대의 끝이거나)
					iron.pop();
					
					// 레이저면 지금까지 막대수만큼 토막이 생김
					if (input.charAt(i - 1) == '(') {
						total += iron.size();
					} else if (input.charAt(i - 1) == ')') { // 막대의 끝이니까 하나만 더생김
						total++;
					}
				}
			}
			System.out.println("#" + test_case + " " + total);
		}
	}
}
