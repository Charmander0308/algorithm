package day05_0808.SWEA.calculator1222;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day05_0808/SWEA/calculator1222/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int strLength = sc.nextInt();
			String str = sc.next();
			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			
			//후위표기식으로 변경
			for(int i = 0; i < strLength; i++) {
				char c = str.charAt(i);
				if(c >= '0' && c <= '9') {
					sb.append(str.charAt(i));
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				} else if(c == '+') {
					stack.push(c);
				}
			}
			
			//몫을 담자
			int ans = 0;
			Stack<Integer> numStack = new Stack<>();

			//후위표기식을 연산한 결과값을 ans에 저장 
			for(int i = 0; i < sb.length(); i++) {
				//더해진 값이 누적되면 안되니까 초기화
				ans = 0;
				char c = sb.charAt(i);
				//문자가 숫자면 int로 바꿔서 numStack에 push
				if(c >= '0' && c <= '9') {
					numStack.push(c - 48);
				} 
				//문자가 +면 지금까지 쌓은 스택을 다 꺼내서 더하고 다시 스택에 저장
				else if(c == '+') {
					//다 꺼내서 더하기
					while(!numStack.isEmpty()) {
						ans += numStack.pop();
					}
					//다시 넣기
					numStack.push(ans);
				}
				
			}
			//완성
			System.out.println("#" + test_case + " " + ans);
			
		}
		
	}

}
