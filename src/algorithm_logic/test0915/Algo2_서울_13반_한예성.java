package algorithm_logic.test0915;

import java.util.Scanner;

public class Algo2_서울_13반_한예성 {
	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	
	static int N;
	static int count;
	static int[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();
			board = new int[N][N];
			count = 0;
			
			bt(0, 0);
			System.out.println("#"+ test_case+ " " + count);
			
		}
		
	}
	
	static void bt(int r, int c) {
		//행의 끝까지 갔다면 1추가
		if(r == N) {
			count++;
			return;
		}
		
		int nextR = r;
		int nextC = c+1;
		//열의 끝까지 갔다면 다음 행으로
		if(nextC == N) {
			nextR = r+1;
			nextC = 0;
		}
		
		//왕을 놓는 경우
		if(promise(r, c)) {
			place(r, c, 1);
			bt(nextR, nextC);
			place(r, c, -1);
		}
		//놓지 않는 경우
		bt(nextR, nextC);
	}

	//배열범위 안인지 체크
	private static boolean isOk(int r, int c) {
		boolean b = false;
		if(r>=0 && r<N && c>=0 && c<N) b = true;
		
		return b;
	}

	//여기에 둘 수 있는지 체크
	private static boolean promise(int r, int c) {
		boolean b = false;
		if(board[r][c] == 0) b = true;
		return b;
	}
	
	static void place(int r, int c, int value) {
		board[r][c]+= value;
		for(int k=0; k<8; k++) {
			int nextR = r + dr[k];
			int nextC = c + dc[k];
			
			if(isOk(nextR, nextC)) {
				board[nextR][nextC]+= value;
			}
		}
	}
	
}
