package day04_0807.baekjoon.palindrome10988;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//일단 맞다고 가정
		int result = 1;
		//입력받기
		String input = sc.next();
		//반만큼 돌아보고 양 끝 대칭하는 자리와 비교
		for(int i = 0; i < input.length()/2; i++) {
			//하나라도 다르면 더이상 비교 안해도되니까 0
			if(input.charAt(i) != input.charAt(input.length()-1-i)) {
				result = 0;
				break;
			}
		}
		//for문을 무사 통과했으면 1, if문에 걸리면 0 
		System.out.println(result);
	}
}
