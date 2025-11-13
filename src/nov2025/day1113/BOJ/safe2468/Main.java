package nov2025.day1113.BOJ.safe2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] area;
	static boolean[][] isVisited;
	//우하좌상
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static class Loc {
		int r; 
		int c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int max = 0;
		area = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				area[i][j] = num;
				
				if(num > max) max = num;
			}
		}
		
//		System.out.println(N);
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(area[i]));
//		}
		
		int answer = 0;
		
		//1부터 가장 높은곳 바로 전까지 측정
		for(int i=0; i<max; i++) {
			isVisited = new boolean[N][N];
			int cnt = function(N, i);
//			System.out.println(i + ": " + cnt);
			if(cnt > answer) answer = cnt;
		}
		
		System.out.println(answer);
		
	}

	private static int function(int N, int rain) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(area[i][j] <= rain) {
					isVisited[i][j] = true;
				}
			}
		}
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isVisited[i][j] == false) {
					bfs(i, j);
					result++;
				}
			}
		}
		
		return result;
		
	}

	private static void bfs(int r, int c) {
		Queue<Loc> q = new ArrayDeque<>();
		Loc loc = new Loc(r, c);
		q.add(loc);
		isVisited[r][c] = true;
		
		while(!q.isEmpty()) {
			Loc now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nextR = now.r + dr[i];
				int nextC = now.c + dc[i];
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >=N || isVisited[nextR][nextC] == true)
					continue;
				
				q.add(new Loc(nextR, nextC));
				isVisited[nextR][nextC] = true;
			}
		}
	}
}
