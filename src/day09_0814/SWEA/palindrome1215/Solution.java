package day09_0814.SWEA.palindrome1215;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day09_0814/SWEA/palindrome1215/sample_in.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String palindrome = sc.next();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i <= N-M; i++) {
				boolean isOk = true;
				for(int j = i; j < M + i; j++) {
					if(palindrome.charAt(j) == palindrome.charAt(i+M-1-j)){
						isOk = false;
						break;
					}
				}
				if(isOk == true) {
					sb.append(palindrome.substring(i, i+M));
				}
			}
			if(sb.isEmpty()) {
				System.out.println("NONE");
			} else {
				while(!sb.isEmpty()) {
					System.out.println(sb);
				}
			}
			
		}
		sc.close();
		
	}

}
