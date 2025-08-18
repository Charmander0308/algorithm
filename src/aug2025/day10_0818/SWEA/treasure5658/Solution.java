package aug2025.day10_0818.SWEA.treasure5658;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
//		int n = 1*16*16 + 15*16 + 7*1;
//		System.out.println(n);
	
		File file = new File("src/aug2025/day10_0818/SWEA/treasure5658/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= 1; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String input = sc.next();
			
			Queue<Character> sixteenNum1 = new LinkedList<>();
			Queue<Character> sixteenNum2 = new LinkedList<>();
			for(int i = 0; i < input.length(); i++) {
				sixteenNum1.add(input.charAt(i));
			}
//			for(int i = 0; i < input.length(); i++) {
//				System.out.print(sixteenNum.poll());
//			}
//			System.out.println();
			
			//숫자들 담을 리스트 
			List<String> numlist = new ArrayList<>();
			
			//for문 돌면서 str에 담은 첫 세글자가 이미 리스트에 있다면 isOk = false로 만들어서 반복문 탈출하기 
			boolean isOk = true;
			
			//세글자씩 꺼내서 리스트에 넣기
			while(sixteenNum1.size() < 3) {
				//문자 하나 빼서 str에 추가, str은 다른 큐에 담아두기
				String str = String.valueOf(sixteenNum1.poll());
				sixteenNum2.add(str.charAt(0));
				
				//3글자씩 끊어서 numlist에 저장
				for(int i = 1; i < 3; i++) {
					str += String.valueOf(sixteenNum1.poll());
					sixteenNum2.add(str.charAt(0));
				}
				numlist.add(str);
			}
			//다른 큐에 담아둔 문자들 다시 원위치
			for(int i = 0; i < input.length(); i++) {
				sixteenNum1.add(sixteenNum2.poll());
			}
			
			for(String s : numlist) {
				System.out.println(s);
			}
			
			
			
			
			
		}
		
		
	}

}
