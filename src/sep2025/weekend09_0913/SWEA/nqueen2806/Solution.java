package sep2025.weekend09_0913.SWEA.nqueen2806;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int N;
	static int cnt;
	
	//0=우 부터 시작, 8방 
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	
	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day21_0911/SWEA/nqueen2806/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();
			cnt = 0;
			int[][] checked = new int[N][N];
			int queen = N;
			
			nqueen(0, 0, checked, queen);
			
			System.out.println(cnt);
		}
		
	}

	private static void nqueen(int r, int c, int[][] checked, int queen) {
		//다왔다!하나 찾았다! 
		if(queen == 0) {
			cnt++;
			return;
		}
		//퀸을 다 못 놓았는데 도착하면 실패 
		if(r >= N) return;
		//열이 범위를 넘어버리면 안됨 
		if(c >= N) {
			nqueen(r+1, 0, checked, queen);
			return;
		}
		
		//현재 위치 
		Loc now = new Loc(r, c);
		
		//퀸을 두는 경우 
		if(isOk(now.r, now.c, checked)) {
			checked[now.r][now.c]++;
			//둔 자리 기준으로 둘 수 없는 곳 체크 
			for(int k=0; k<8; k++) {
				for(int dist=1; dist<N; dist++) {
					int nextR = now.r + dr[k]*dist;
					int nextC = now.c + dc[k]*dist;
					
					if(!rangeCheck(nextR, nextC)) continue;
					checked[nextR][nextC]++;
				}
			}
			//다음 행으로 이동 
			nqueen(r+1, 0, checked, queen-1);
			//다녀왔으면 체크한 곳들 원복 
			checked[now.r][now.c]--;
			for(int k=0; k<8; k++) {
				for(int dist=1; dist<N; dist++) {
					int nextR = now.r + dr[k]*dist;
					int nextC = now.c + dc[k]*dist;
					
					if(!rangeCheck(nextR, nextC)) continue;
					checked[nextR][nextC]--;
				}
			}
		}
		//퀸을 두지 않는 경우 
		nqueen(r, c+1, checked, queen);
	}
	
	private static boolean rangeCheck(int r, int c) {
		boolean b = false;
		if(r>=0 && r<N && c>=0 && c<N) {
			b = true;
		}
		return b;
	}

	//둘 수 있는지 체크 
	private static boolean isOk(int r, int c, int[][] checked) {
		boolean b = false;
		if(r>=0 && r<N && c>=0 && c<N && checked[r][c]==0) {
			b = true;
		}
		return b;
	}
}
