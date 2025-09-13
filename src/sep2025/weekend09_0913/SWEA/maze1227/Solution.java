package sep2025.weekend09_0913.SWEA.maze1227;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static final int N = 100;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/weekend09_0913/SWEA/maze1227/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int tc = sc.nextInt();
			int[][] maze = new int[N][N];
			boolean[][] wall = new boolean[N][N];
			Loc start = new Loc(0, 0);
			Loc end = new Loc(0, 0);
			
			for(int i=0; i<N; i++) {
				String line = sc.next();
				for(int j=0; j<N; j++) {
					int value = maze[i][j] = line.charAt(j)-'0';
					
					if(value == 1) wall[i][j] = true;
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
			
			int ans = bfs(start, end, wall);
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}

	private static int bfs(Loc start, Loc end, boolean[][] wall) {
		Queue<Loc> q = new ArrayDeque<>();
		q.add(start);
		wall[start.r][start.c] = true;
		int result = 0;
		
		while(!q.isEmpty()) {
			Loc now = q.poll();
			if(now.r == end.r && now.c == end.c) {
				result = 1;
				break;
			}
			
			
			for(int k=0; k<4; k++) {
				int nextR = now.r + dr[k];
				int nextC = now.c + dc[k];
				
				if(canMove(nextR, nextC, wall)) {
					q.add(new Loc(nextR, nextC));
					wall[nextR][nextC] = true;
				}
			}
		}
		
		return result;
	}

	private static boolean canMove(int nextR, int nextC, boolean[][] wall) {
		boolean b = false;
		if(nextR>=0 && nextC>=0 && nextR<N && nextC<N && !wall[nextR][nextC]) {
			b = true;
		}
		return b;
	}

}
