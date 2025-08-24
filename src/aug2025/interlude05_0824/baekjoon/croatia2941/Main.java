package aug2025.interlude05_0824.baekjoon.croatia2941;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int count = 0;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(c == 'c') {
				if(i+1 < word.length() && (word.charAt(i+1) == '=' || word.charAt(i+1) == '-')) i++;
			} else if(c == 'd') {
				if(i+1 < word.length() && i+2 < word.length() && word.charAt(i+1) == 'z' && word.charAt(i+2) == '=') {
					i+=2;
				} else if(i+1 < word.length() && word.charAt(i+1) == '-'){
					i++;
				}
			} else if(c == 'l') {
				if(i+1 < word.length() && word.charAt(i+1) == 'j') i++;
			} else if(c == 'n') {
				if(i+1 < word.length() && word.charAt(i+1) == 'j') i++;
			} else if(c == 's') {
				if(i+1 < word.length() && word.charAt(i+1) == '=') i++;
			} else if(c == 'z') {
				if(i+1 < word.length() && word.charAt(i+1) == '=') i++;
			}
			count++;
		}
		
		System.out.println(count);
		
	}
}
