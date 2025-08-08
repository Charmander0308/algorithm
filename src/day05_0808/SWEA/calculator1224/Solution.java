package day05_0808.SWEA.calculator1224;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day05_0808/SWEA/calculator1224/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int inputInt = sc.nextInt();
			String inputString = sc.next();
			
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder(); 
			
			//후위표기식 만들기
			for(int i = 0; i < inputInt; i++) {
				char c = inputString.charAt(i);
				//숫자면 sb에 더하기
				if(c >= '0' && c <= '9') {
					sb.append(c);
				} 
				//연산자인 경우
				else if(c == '(' || c == '+' || c == '*') {
					//+이고, 항아리 맨 위가 *라면
					if(c == '+' && stack.peek() == '*') {
						//맨 위가 *이면 *을 pop해서 sb에 넣기
						while(stack.peek() == '*') {
							sb.append(stack.pop());
						}
					}
					//연산자는 stack에 넣기
					stack.push(c);
				} 
				//닫는 괄호면 여는괄호 나올때까지 계속 append
				else if(c == ')') {
					while(stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop();
				}
			}
			
			
			//후위표기식 연산하기
			Stack<Integer> stack2 = new Stack<>();
			int ans = 0;
			for(int i = 0; i < sb.length(); i++) {
				int num = 0;
				char c = sb.charAt(i);
				//숫자면 항아리에 담기
				if(c >= '0' && c <= '9') {
					stack2.push(c-48);
				} else {
					//더하기면 맨 위 두개 꺼내서 더하고 다시 넣기
					if(c == '+') {
						num = stack2.pop() + stack2.pop();
						stack2.push(num);
					} 
					//곱하기면 맨위 두개 꺼내서 곱하고 다시 넣기
					else if(c == '*') {
						num = stack2.pop() * stack2.pop();
						stack2.push(num);
					}
				}
				//마지막 값이 ans로 남음
				ans = num;
			}
			//완성
			System.out.println("#" + test_case + " " +ans);
			
		}
		
	}

}
