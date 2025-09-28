package sep2025.day36_0928.BOJ.colorWeekness10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static char[][] grid;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static class Loc {
		int r, c;
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		grid = new char[N][N];
		for(int i=0; i<N; i++) {
			String line = sc.next();
			for(int j=0; j<N; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		
		int case1 = bfs('R') + bfs('G') + bfs('B');
		int case2 = bfs('R', 'G') + bfs('B');
		
		System.out.println(case1 + " " + case2);
		
	}

	private static int bfs(char c) {
		Queue<Loc> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(grid[i][j] == c && !visited[i][j]) {
					//해당 문자면 좌표 큐에 넣기
					q.offer(new Loc(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						Loc loc = q.poll();
						for(int k=0; k<4; k++) {
							int nr = loc.r + dr[k];
							int nc = loc.c + dc[k];
							
							if(nr >=0 && nr <N && nc >=0 && nc <N && !visited[nr][nc] && grid[nr][nc] == c) {
								q.offer(new Loc(nr, nc));
								visited[nr][nc] = true;
							}
						}
					}
					result++;
				}
			}
		}
		return result;
	}
	
	private static int bfs(char c1, char c2) {
		Queue<Loc> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if((grid[i][j] == c1 || grid[i][j] == c2) && !visited[i][j]) {
					//해당 문자면 좌표 큐에 넣기
					q.offer(new Loc(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						Loc loc = q.poll();
						for(int k=0; k<4; k++) {
							int nr = loc.r + dr[k];
							int nc = loc.c + dc[k];
							
							if(nr >=0 && nr <N && nc >=0 && nc <N && !visited[nr][nc] && (grid[nr][nc] == c1 || grid[nr][nc] == c2)) {
								q.offer(new Loc(nr, nc));
								visited[nr][nc] = true;
							}
						}
					}
					result++;
				}
			}
		}
		return result;
	}
}
