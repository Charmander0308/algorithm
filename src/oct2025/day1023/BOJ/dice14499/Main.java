package oct2025.day1023.BOJ.dice14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//지도 세로
		int M = Integer.parseInt(st.nextToken());	//지도 가로
		int x = Integer.parseInt(st.nextToken());	//주사위 x좌표
		int y = Integer.parseInt(st.nextToken());	//주사위 y좌표
		int K = Integer.parseInt(st.nextToken());	//명령 개수
		
		//지도 그리기
		int[][] map = new int[N][M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//명령(1:동, 2:서, 3:남, 4:북)
		st = new StringTokenizer(br.readLine());
		Queue<Integer> order = new ArrayDeque<>();
		for(int i=0; i<K; i++) {
			order.add(Integer.parseInt(st.nextToken()));
		}
		
		//주사위임. [0]은 안씀
		/* 요래생김
		 * 	 2
		 * 4 1 3
		 *   5
		 *   6
		 */
		int[] dice = new int[7];
		int start = 1;
		
		for(int i=0; i<K; i++) {
			int nowOrder = order.poll();
			int nextX = x + dr[nowOrder];
			int nextY = y + dc[nowOrder];
			
			if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
				x = nextX;
				y = nextY;
			}
			
			
			
			
			
			
			
		}
		
		
		
	}
}
