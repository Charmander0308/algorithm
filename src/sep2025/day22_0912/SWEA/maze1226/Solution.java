package sep2025.day22_0912.SWEA.maze1226;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N = 16;
	static boolean[][] wall;
	static Loc end;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day22_0912/SWEA/maze1226/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int tc = sc.nextInt();
			int[][] maze = new int[N][N];
			wall = new boolean[N][N];
			Loc start = new Loc(0, 0);
			end = new Loc(0, 0);
			
			for(int i=0; i<N; i++) {
				String line = sc.next();
				for(int j=0; j<N; j++) {
					int value = maze[i][j] = line.charAt(j) - '0';
					
					if(value == 1) {
						wall[i][j] = true;
					}
					if(value == 2) {
						start.r = i;
						start.c = j;
					}
					if(value == 3) {
						end.r = i;
						end.c = j;
					}
				}
			}
			int ans = bfs(start);
			System.out.println("#" + tc + " " + ans);
		}
		
	}

	private static int bfs(Loc l) {
		int isOk = 0;
		Queue<Loc> q = new ArrayDeque<>();
		q.add(l);
		wall[l.r][l.c] = true;
		while(!q.isEmpty()) {
			Loc now = q.poll();
			if(now.r == end.r && now.c == end.c) {
				isOk = 1;
				break;
			}
			
			for(int k=0; k<4; k++) {
				int nextR = now.r + dr[k];
				int nextC = now.c + dc[k];
				
				if(canMove(nextR, nextC)) {
					q.add(new Loc(nextR, nextC));
					wall[nextR][nextC] = true;
				}
			}
		}
		return isOk;
	}
	
	static boolean canMove(int r, int c) {
		boolean b = false;
		if(r>=0 && r<N && c>=0 && c<N && !wall[r][c]) {
			b = true;
		}
		return b;
	}
}


