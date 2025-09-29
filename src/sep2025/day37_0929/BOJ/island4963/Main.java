package sep2025.day37_0929.BOJ.island4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

	static class Loc {
		int r, c;
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			int[][] area = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<Loc> q = new LinkedList<>();
			int result = 0;
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(area[i][j] == 1 && !visited[i][j]) {
						q.offer(new Loc(i, j));
						visited[i][j] = true;
						
						while(!q.isEmpty()) {
							Loc loc = q.poll();
							
							for(int k=0; k<8; k++) {
								int nr = loc.r + dr[k];
								int nc = loc.c + dc[k];
								
								if(nr>=0 && nr<h && nc>=0 && nc<w && !visited[nr][nc] && area[nr][nc]==1) {
									q.offer(new Loc(nr, nc));
									visited[nr][nc] = true;
								}
							}
						}
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}
}
