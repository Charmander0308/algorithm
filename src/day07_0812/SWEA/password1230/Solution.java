package day07_0812.SWEA.password1230;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day07_0812/SWEA/password1230/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			//원본 암호문 뭉치 속 암호문의 개수
			int N = sc.nextInt();
			//원본 암호문 뭉치
			List<String> passwords = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				passwords.add(sc.next());
			}
			//명령어의 개수
			int M = sc.nextInt();
			
			//명령어
			List<String> commands = new LinkedList<>(); 
			for(int i = 0; i < M; i++) {
				commands.add(sc.next());
			}
			
			for(int i = 0; i < M; i++) {
				String s = commands.get(i);
				if(s.equals("I")) {
					
				}
				
			}
			
			
			
			
			
			
			
			
			
		}
		
	}

}
