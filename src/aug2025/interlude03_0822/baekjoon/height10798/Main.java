package aug2025.interlude03_0822.baekjoon.height10798;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] line = new String[5];	//입력 담기
		int[] size = new int[5];		//입력 길이 재기
		int max = 0;	//가장 긴 길이만큼 돌릴거라 담아두기
		
		for(int i = 0; i < 5; i++) {
			line[i] = sc.next();	//입력받기
			size[i] = line[i].length();	//받은 문자열 길이 저장하기
			if(size[i] > max) max = size[i];	//제일 긴 길이 저장용
		}
		//정답 담는용
		StringBuilder sb = new StringBuilder();
		//가장 긴 길이만큼 돌아가며 하나씩 문자 넣기
		for(int i = 0; i < max; i++) {
			for(int j = 0; j < 5; j++) {
				//런타임에러 방지용
				if(size[j] > 0) {
					sb.append(line[j].charAt(i));
					size[j]--;
				}
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
