package aug2025.liberation_day_0815.SWEA.palindrome21936;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day09_0814/SWEA/palindrome21936/sample_in.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			//문자열 길이
			int N = sc.nextInt();
			//회문길이
			int M = sc.nextInt();
			//회문 저장
			String palindrome = sc.next();
			//회문 검증 후 저장용
			StringBuilder sb = new StringBuilder();
			
			//처음부터 시작
			for(int i = 0; i <= N-M; i++) {
				//i부터 M만큼 길이의 문자열을 저장
				String str = palindrome.substring(i, i+M);
				boolean isOk = true;
				//대칭점에 있는 문자와 비교
				for(int j = 0; j < str.length()/2; j++) {
					//다르면 회문 아니므로 더이상 이번 문자열 검증 필요x
					if(str.charAt(j) != str.charAt(M-1-j)) {
						isOk = false;
						break;
					}
				}
				//조건문 잘 통과했으면 회문이므로 해당 문자열 저장
				if(isOk == true) {
					sb.append(palindrome.substring(i, i+M));
				}
			}
			
			//출력
			System.out.print("#" + test_case + " ");
			if(sb.length() == 0) {
				System.out.println("NONE");
			} else {
				System.out.println(sb);
			}
		}
		sc.close();
	}
}
