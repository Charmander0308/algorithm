package aug2025.weekend04_0817.SWEA.magnetic1220;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/aug2025/weekend04_0817/SWEA/magnetic1220/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int length = sc.nextInt();
			int[][] table = new int[length][length];
			
			for(int r = 0; r < length; r++) {
				for(int c = 0; c < length; c++) {
					table[r][c] = sc.nextInt();
				}
			}
			
			int deadlock = 0; 
			int move = 0;
			for(int r = 0; r < length; r++) {
				for(int c = 0; c < length; c++) {
					//자성체가 N인 경우 
					if(table[r][c] == 1) {
						int nextR = r + 1;
						//다음 칸이 빈칸이면 이동 
						if(table[nextR][c] == 0) {
							table[nextR][c] = 1;
							table[r][c] = 0;
							move++;
						}
						//다음칸이 S자성체라면 교착 1증가 
						else if(table[nextR][c] == 2) {
							deadlock++;
						}
						
					}
				}
			}
			
			
			
			
			
			
			
		}
		
	}

}
