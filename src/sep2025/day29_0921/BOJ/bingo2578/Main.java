package sep2025.day29_0921.BOJ.bingo2578;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		int ans = 0;
		while(cnt < 25) {
			int bingo = 0;
			cnt++;
			int num = sc.nextInt();
			//답 이미 나왔으면 그냥 남은 값 입력만 받는용
			if(ans != 0) continue;
			
			//빙고체크
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(board[i][j] == num) {
						board[i][j] = 0;
						break;
					}
				}
			}
			
			//가로줄 빙고검사
			for(int i=0; i<5; i++) {
				boolean isOk = true;
				for(int j=0; j<5; j++) {
					if(board[i][j] != 0) {
						isOk = false;
						break;
					}
				}
				if(isOk == true) bingo++;
			}
			//세로줄 빙고검사
			for(int i=0; i<5; i++) {
				boolean isOk = true;
				for(int j=0; j<5; j++) {
					if(board[j][i] != 0) {
						isOk = false;
						break;
					}
				}
				if(isOk == true) bingo++;
			}
			//대각선 빙고검사
			boolean isOk = true;
			for(int i=0; i<5; i++) {
				if(board[i][i] != 0) {
					isOk = false;
					break;
				}
			}
			if(isOk == true) bingo++;
			
			isOk = true;
			for(int i=0; i<5; i++) {
				if(board[i][4-i] != 0) {
					isOk = false;
					break;
				}
			}
			if(isOk == true) bingo++;
			
			if(bingo >= 3 && ans == 0) {
				ans = cnt;
			}
		}
		
		System.out.println(ans);
		
	}
}
