package day04_0807.SWEA.bracket1218;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("src/day04_0807/SWEA/bracket1218/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int total = sc.nextInt();
			String input = sc.next();
			Stack<Character> stack = new Stack<>();
			
			//일단 다 맞다고 가정하자. 그리고 아닌걸 찾자 
			int isOk = 1;
			
			for(int i = 0; i < total; i++) {
				//여는 괄호면 푸쉬
				if(input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(' || input.charAt(i) == '<') {
					stack.push(input.charAt(i));
				} else {	//닫는 괄호면 항아리 가장 위 내용물 확인
					if(input.charAt(i) == '}') {
						if(stack.peek() == '{') {	//규칙에 맞으면 무사통과 + 짝 맞춰서 내용물 제거
							stack.pop();
						} else {
							isOk = 0;	//규칙에 위배되면 isOk = 0이고 더이상 검사할 필요없으니 for문 탈출, 이하 동일
							break;
						}
					} else if(input.charAt(i) == ']') {
						if(stack.peek() == '[') {
							stack.pop();
						} else {
							isOk = 0;
							break;
						}
					} else if(input.charAt(i) == ')') {
						if(stack.peek() == '(') {
							stack.pop();
						} else {
							isOk = 0;
							break;
						}
					} else if(input.charAt(i) == '>') {
						if(stack.peek() == '<') {
							stack.pop();
						} else {
							isOk = 0;
							break;
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + isOk);
			
		}
		
	}

}

