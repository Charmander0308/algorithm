package algorithm_logic.test0811;

import java.util.Scanner;

public class Algo1_서울_13_한예성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			String S = sc.next();
			//문자열을 문자 배열로 만들기
			char[] charArr = S.toCharArray();
			//소문자는 대문자로 바꿔주기
			for(int i =0; i < charArr.length; i++) {
				if(charArr[i] >= 'a' && charArr[i] <='z') {
					charArr[i] = (char) (charArr[i] - 32);
				}
			}
			//정답 제출용 sb
			StringBuilder sb = new StringBuilder();
			//같은 문자 횟수 세는용
			int count = 0;
			//첫 문자열은 그냥 집어넣고 카운트 1증가
			for(int i = 0; i < charArr.length; i++) {
				if(i==0) {
					sb.append(charArr[i]);
					count++;
				} else {
					//전과 같으면 카운트만 증가
					if(charArr[i] == charArr[i-1]) {
						count++;
					} else {
						//다르면 지금까지 카운트를 sb에 추가하고 초기화, 새로운 문자를 sb에 넣고 카운트 시작
						sb.append(count);
						count=0;
						sb.append(charArr[i]);
						count++;
					}
				}
			}
			//마지막 문자에 대한 카운트 sb에 추가
			sb.append(count);
			
			//출력
			System.out.println("#" + test_case + " " + sb.toString());
			
		}
		
	}

}
