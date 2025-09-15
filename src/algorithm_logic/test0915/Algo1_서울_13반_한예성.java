package algorithm_logic.test0915;

import java.util.Scanner;

public class Algo1_서울_13반_한예성 {
	//0=동, 4방
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	//좌표 객체
	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;	//배열사이즈
	static int[][] maze;	//미로
	static boolean[][] visited;	//방문체크
	static Loc start;	//시작
	static Loc end;		//끝
	static int ans;		//정답
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			//초기화 및 값 세팅
			N = sc.nextInt();
			maze = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					maze[i][j] = sc.nextInt();
					if(maze[i][j] == 1) visited[i][j] = true;	//벽은 방문불가
				}
			}
			ans = -1;
			start = new Loc(0, 0);
			end = new Loc(N-1, N-1);
			visited[0][0] = true;	//시작위치는 방문체크
			
			dfs(start, 0);
			System.out.println("#" + test_case + " " + ans);
			
		}
	}
	
	static void dfs(Loc now, int move) {
		//종료조건: end와 좌표값이 같으면 리턴
		if(now.r == end.r && now.c == end.c) {
			if(ans == -1) ans = move;
			else ans = Math.min(ans, move);
			return;
		}
		//델타탐색
		for(int i=0; i<4; i++) {
			int nextR = now.r + dr[i];
			int nextC = now.c + dc[i];
			
			// 이동 가능하면 재귀호출, move 1증가
			if(isOk(nextR, nextC) && !visited[nextR][nextC]) {
				visited[nextR][nextC] = true;
				dfs(new Loc(nextR, nextC), move+1);
			}
		}
	}
	
	//배열 범위 안인지 체크용
	static boolean isOk(int r, int c) {
		boolean b = false;
		if(r >= 0 && r < N && c >= 0 && c < N) b = true;
		
		return b;
	}
	
}
