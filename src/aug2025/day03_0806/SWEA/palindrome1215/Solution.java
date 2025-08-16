package aug2025.day03_0806.SWEA.palindrome1215;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("src/day03_0806/SWEA/palindrome1215/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int wordSize = sc.nextInt();
			String[] inputArr = new String[8];
			char[][] charArr = new char[8][8];
			//주어진 값 받기
			for(int i = 0; i < 8; i++) {
				inputArr[i] = sc.next();
			}
			//2차원 배열에 문자 단위로 소분하기
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					charArr[i][j] = inputArr[i].charAt(j);
				}
			}
//			for(int i = 0; i < 8; i++) {
//				for(int j = 0; j < 8; j++) {
//					System.out.print(charArr[i][j] + " "); 
//				}
//				System.out.println();
//			}
			int ans = 0;
			//가로 회문 체크
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8 - wordSize + 1; j++) {
					
					
					
				}
			}
			
			
			
			
			
			
			
			System.out.println();
			
		}
		
	}

}
