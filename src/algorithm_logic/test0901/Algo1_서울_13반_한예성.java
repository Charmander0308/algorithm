package algorithm_logic.test0901;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Algo1_서울_13반_한예성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T; test_case++) {
			List<Character> list = new LinkedList<>();
			String line = sc.next();
			//문자열을 문자단위로 리스트에 담기
			for(int i=0; i<line.length(); i++) {
				list.add(line.charAt(i));
			}
			//정답 세는 변수
			int count = 0;
			//한번씩 회전
			for(int i=0; i<line.length(); i++) {
				//괄호 쌍 체크용
				Stack<Character> st = new Stack<>();
				//스택에 리스트 순서대로 넣기
				for(int j=0; j<line.length(); j++) {
					st.add(list.get(j));
				}
				//맞는 괄호인지 체크
				boolean isOk = true;
				//닫는괄호면 1증가, 여는 괄호면 1 감소
				int num = 0;
				for(int j=0; j<line.length(); j++) {
					if(st.peek() == '(') {
						//쌍이 안맞으면 탈락
						if(num == 0) {
							isOk = false;
							break;
						}
						st.pop();
						num--;
					} else if(st.peek() == ')') {
						st.pop();
						num++;
					}
				}
				//for문 무사통과했다면 정답 1 증가
				if(isOk == true) count++;
				//맨 앞의 문자를 맨뒤로 넘기기
				list.add(list.get(0));
				list.remove(0);
			}
			
			//정답
			System.out.println("#" + test_case + " " + count);
			
		}
	}
}
