package sep2025.day29_0921.BOJ.snake3190;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static class Snake {
		int r, c;

		public Snake(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//보드크기
		int k = sc.nextInt();	//사과 개수
		int[][] board = new int[N][N];
		//사과 위치 등록
		for(int i=0; i<k; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			board[r][c] = 4;	
		}
		int l = sc.nextInt();	//뱀의 방향전환 횟수
		Map<Integer, String> turn = new HashMap<>();
		//뱀 드리프트 
		for(int i=0; i<l; i++) {
			int num = sc.nextInt();
			String dir = sc.next();
			turn.put(num, dir);
		}
		
		//시작 세팅
		int r = 0;
		int c = 0;
		board[r][c] = 1;
		int dir = 0;	//오른쪽
		int sec = 0;	//초
		Queue<Snake> q = new ArrayDeque<>();
		q.add(new Snake(r, c));
		
		while(true) {
			sec++;
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			
			//벽에 박으면 끝
			if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) break;
			//자기몸에 박아도 끝
			if(board[nextR][nextC] == 1) break;
			
			//사과 먹은게 아니면 늘어난 꼬리 줄이기 
			if(board[nextR][nextC] != 4) {
				board[q.peek().r][q.peek().c] = 0;
				q.poll();
			}
			//꿈틀꿈틀
			board[nextR][nextC] = 1;
			q.add(new Snake(nextR, nextC));
			r = nextR;
			c = nextC;
			
			
			//방향전환 시간이면 턴
			if(turn.containsKey(sec)) {
				String s = turn.get(sec);
				//L이면 왼쪽으로 턴
				if(s.equals("L")) {
					dir = (dir - 1 + 4) % 4;
				}
				//D면 오른쪽으로 턴
				else if(s.equals("D")) {
					dir = (dir + 1) % 4;
				}
			}
		}
		
		System.out.println(sec);
		
	}

}
