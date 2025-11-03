package nov2025.day1103.BOJ.word2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] word = new String[N];
		for(int i=0; i<N; i++) {
			word[i] = br.readLine();
		}
		int[][] alphabet = new int[N][26];
		//알파벳을 정수로 생각해서 정수배열에 개수 체크
		for(int i=0; i<N; i++) {
			for(int j=0; j<word[i].length(); j++) {
				alphabet[i][word[i].charAt(j)-'A']++;
			}
		}
		int similar = 0;
		//diff는 알파벳 다른 개수
		for(int i=1; i<N; i++) {
			int diff = 0;
			for(int j=0; j<26; j++) {
				if(alphabet[i][j] != alphabet[0][j]) {
					diff += Math.abs(alphabet[0][j] - alphabet[i][j]); 
				}
			}
			//두 단어의 길이가 같으면 하나의 문자를 다른 문자로 바꾸면 같아지는 경우까지 생기므로 diff를 2 이하로 정함
			if(word[i].length() == word[0].length()) {
				if(diff <= 2) similar++;
			}
			//길이 다르면 1 이하만 ok
			else {
				if(diff <= 1) similar++;
			}
		}
		System.out.println(similar);
	}
	
}
