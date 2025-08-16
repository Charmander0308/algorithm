package aug2025.day03_0806.SWEA.euiseok5356;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day03_0806/SWEA/euiseok5356/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			//입력값 5줄이니까 한줄씩 보관용
			String[]input = new String[5];
			//가장 긴 문자열 길이 저장
			int maxLength = 0;
			
			//문자열 입력받기 + 가장 긴 문자열의 길이 저장  
			for(int i = 0; i < 5; i++) {
				input[i] = sc.next();
				if(input[i].length() > maxLength) {
					maxLength = input[i].length();
				}
			}
			
			//가장 긴 문자열 길이를 기준으로 스위칭한 문자열 담을 새 배열 만들기
			String[] ansArr = new String[maxLength*5]; 
			
			//인덱스 i 의 j번째 문자는 스위칭 시 i+(j*5)순서에 위치하게 됨
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < input[i].length(); j++) {
					ansArr[i+(j*5)] = String.valueOf(input[i].charAt(j));
				}
			}
			//컬럼길이가 서로 다른 배열일 시, null이 포함되므로 null 제거하고 문자열 한줄로 이어주기
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < maxLength*5; i++) {
				if(ansArr[i] != null)
				sb.append(ansArr[i]);
			}
			//완성
			System.out.println("#" + test_case + " " + sb);
		}
		
	}

}
