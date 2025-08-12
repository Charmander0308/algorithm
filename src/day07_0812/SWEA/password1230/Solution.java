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
		int T = 10;
		
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
			for(int i=0; i < M; i++) {
				//어떤 명령어인가? 
				String order = sc.next();
				//인덱스와 암호 수를 받아서 반복문으로 다음 문자열들 받아서 해당 위치에 삽입 
				if(order.equals("I")) {
					int index = sc.nextInt();
					int count = sc.nextInt();
					for(int j = 0; j < count; j++) {
						passwords.add(index + j, sc.next());
					}
				}
				//인덱스와 암호 수를 받아서 해당 위치에서 수만큼 삭제 
				else if(order.equals("D")) {
					int index = sc.nextInt();
					int count = sc.nextInt();
					for(int j = 0; j < count; j++) {
						passwords.remove(index);
					}
				}
				//수량을 받고, 문자열들을 받아 리스트 맨 뒤에 붙인다 
				else if(order.equals("A")){
					int count = sc.nextInt();
					for(int j = 0; j < count; j++) {
						passwords.add(sc.next());
					}
				}
			}
			//나오세요~ 
			System.out.print("#" + test_case);
			for(int i = 0; i < 10; i++) {
				System.out.print(" "+passwords.get(i));
			}
			System.out.println();
				
			
		}
		
	}

}
