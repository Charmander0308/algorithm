package sep2025.day18_0908.SWEA.cheese7733;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
	static class Location {
		int r, c;
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day18_0908/SWEA/cheese7733/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] > max) max = map[i][j];	//최대값 저장
				}
			}
			
			int answer = 0;
			for(int i=1; i<=max; i++) {
				visited = new boolean[N][N];
				int piece = 0;
				if(i == 1) piece = 1;	//1이상이니까 처음엔 무조건 한덩이
				else {
					for(int r=0; r<N; r++) {
						for(int c=0; c<N; c++) {
							//새로운 덩어리 발견하면 탐색하고 조각 수 1추가
							if(map[r][c] > 0 && !visited[r][c]) {
								bfs(r, c);
								piece++;
							}
						}
					}
				}
				answer = Math.max(answer, piece);
				//요정이 한입
				fairyEat();
			}
			
			System.out.println("#" + test_case + " " + answer);
			
			
		}
	}
	
	//요정이 1이상인 치즈는 1씩 다 먹음
	static void fairyEat() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] > 0) map[i][j]--;
			}
		}
	}
	
	//덩이 끝까지 탐색
	static void bfs(int r, int c) {
		Queue<Location> q = new ArrayDeque<>();
		q.add(new Location(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Location now = q.poll();
			
			for(int k=0; k<4; k++) {
				int nr = now.r + dr[k];
				int nc = now.c + dc[k];
				
				if(nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] > 0 && !visited[nr][nc]) {
					q.add(new Location(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}
}
