package sep2025.day14_0901.BOJ.cogwheel14891;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] cogwheel = new int[4][8];
		
		for(int i=0; i<4; i++) {
			String line = sc.next();
			for(int j=0; j<8; j++) {
				cogwheel[i][j] = line.charAt(j) - '0';
			}
		}
		
		int k = sc.nextInt();
		for(int i=0; i<k; i++) {
			Deque<Integer> cog1 = new ArrayDeque<>();
			Deque<Integer> cog2 = new ArrayDeque<>();
			Deque<Integer> cog3 = new ArrayDeque<>();
			Deque<Integer> cog4 = new ArrayDeque<>();
			
			for(int j=0; j < 8; j++) {
				cog1.addLast(cogwheel[0][j]);
				cog2.addLast(cogwheel[1][j]);
				cog3.addLast(cogwheel[2][j]);
				cog4.addLast(cogwheel[3][j]);
			}
			
			int cogNo = sc.nextInt();
			int dir = sc.nextInt();
			
			//오른쪽 방향 기준 탐색
			for(int j = cogNo; j < 4; j++) {
				//같은 극이면 안돌아감
				if(cogwheel[j-1][2] == cogwheel[j][6]) {
					break;
				}
				
			}
			//왼쪽 방향 기준 탐색
			for(int j = cogNo; j > 1; j++) {
				//같은 극이면 안돌아감
				if(cogwheel[j-1][6] == cogwheel[j-2][2]) {
					break;
				}
			}
			
		}
	
	}
}
