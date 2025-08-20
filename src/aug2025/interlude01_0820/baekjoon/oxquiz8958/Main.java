package aug2025.interlude01_0820.baekjoon.oxquiz8958;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int total = 0;	//총점 
			int count = 0;	//이번문제 점수
			String line = sc.next();	//문자열 받기
			
			for(int i = 0; i < line.length(); i++) {
				//맞추면 이번문제 점수에 1점 추가
				if(line.charAt(i) == 'O') count++;
				//틀리면 이번문제 점수 0으로 리셋
				else if(line.charAt(i) == 'X') count = 0;
				//문제마다 count를 total에 더해주기
				total += count;
			}
			//당신의 점수는
			System.out.println(total);
		}
	}
}
