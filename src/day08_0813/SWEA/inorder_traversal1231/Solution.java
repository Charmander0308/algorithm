package day08_0813.SWEA.inorder_traversal1231;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day08_0813/SWEA/inorder_traversal1231/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int count = sc.nextInt();
			sc.nextLine();
			
			//count만큼 줄 읽기
			for(int i = 0; i < count; i++) {
				String line = sc.nextLine();
				//
				StringTokenizer st = new StringTokenizer(line);
				int parentNum = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				
				while(st.hasMoreTokens()) {
					int childNum = Integer.parseInt(st.nextToken());
				}
				
			}
			
			
			
		}
		
	}

}
