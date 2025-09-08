package sep2025.day18_0908.SWEA.mine1868;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N;
	static char[][] poppingMap;	//원본 지뢰찾기 맵
	static int[][] mineCountMap;	//해당 칸 주위에 지뢰가 몇인지 저장하는 복사본
	static boolean[][] visited;	//방문표시용 복사본
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static class Location {
		int r;
		int c;

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		File file = new File("src/sep2025/day18_0908/SWEA/mine1868/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();	//표 사이즈
			//지뢰 맵 받기
			poppingMap = new char[N][N];
			mineCountMap = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				String s = sc.next();
				for(int j=0; j<N; j++) {
					poppingMap[i][j] = s.charAt(j);
				}
			}
			//클릭횟수 카운트
			int count = 0;
			
			preprocessMineCount();
			
			//0누르는 경우에 대한 카운트
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(poppingMap[i][j] == '.' && mineCountMap[i][j] == 0 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			
			//남은 미탐색인 .들을 눌러주기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(poppingMap[i][j] == '.' && !visited[i][j]) {
						visited[i][j] = true;
						count++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + count);
			
		}//test_case
		
	}//main
	
	//주변 지뢰개수 복사본에 표시해주기
	public static void preprocessMineCount() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//지뢰면 패스
				if(poppingMap[i][j] == '*') continue;
				
				int countMine = 0;
				for(int k=0; k<8; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					
					//배열 벗어나면 패스
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;	
					//지뢰 발견하면 countMine 1증가
					if(poppingMap[nr][nc] == '*') countMine++;
				}
				//찾은 지뢰수만큼 적어두기
				mineCountMap[i][j] = countMine;
			}
		}
	}
	
	//0을 클릭하면 연쇄적으로 열리는 모든 칸 방문처리
	public static void bfs(int r, int c) {
		Queue<Location> q = new ArrayDeque<>();
		
		visited[r][c] = true;
		q.add(new Location(r, c));
		
		while(!q.isEmpty()) {
			Location now = q.poll();
			
			//현재 위치가 0인 경우에만 8방 확장
			if(mineCountMap[now.r][now.c] == 0) {
				for(int k=0; k<8; k++) {
					int nr = now.r + dr[k];
					int nc = now.c + dc[k];
					
					//배열 벗어나면 패스
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;	

					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Location(nr, nc));
					}
				}
			}
		}
		
	}

}
