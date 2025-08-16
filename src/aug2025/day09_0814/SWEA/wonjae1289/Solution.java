package aug2025.day09_0814.SWEA.wonjae1289;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day09_0814/SWEA/wonjae1289/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String line = sc.nextLine();
			int[] resultMemory = new int[line.length()];
			for(int i = 0; i < line.length(); i++) {
				resultMemory[i] =  line.charAt(i)-'0';
			}
//			System.out.println(Arrays.toString(resultMemory));
			//길이가 같은 초기배열 생성 
			int[] initialMemory = new int[resultMemory.length];
//			System.out.println(Arrays.toString(initialMemory));
			//횟수 세는 변수 
			int count = 0;
			//처음부터 끝까지 순회하며 값이 다르면 해당 인덱스 값부터 끝까지 다 바꾸기 
			for(int i = 0; i < resultMemory.length; i++) {
				if(initialMemory[i] != resultMemory[i]) {
					for(int j = i; j < resultMemory.length; j++) {
						initialMemory[j] = -(initialMemory[j]-1);
					}
					//바꾼 횟수 1 증가 
					count++;
				}
//			System.out.println(Arrays.toString(initialMemory) + "count=" + count);
			}
			System.out.println("#" + test_case + " " +count);
			
		}
		sc.close();
	}

}
