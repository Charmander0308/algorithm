package aug2025.day12_0828.baekjoon.banner14716;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//[0]이 북쪽이고 시계방향으로 돌기
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
 	static int M, N;
 	static int[][] area;
 	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		area = new int[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				area[i][j] = sc.nextInt();
			}
		}
		
		int count = 0;
		for(int r=0; r<M; r++) {
			for(int c=0; c<N; c++) {
				if(area[r][c]==1) {
					count++;	//새로운 글자 발견
					bfs(r, c);
				}//if(area[r][c]==1)
			}
		}
		System.out.println(count);
	}
	
	public static void bfs(int r, int c) {
		Queue<Integer> saveR = new LinkedList<>();
		Queue<Integer> saveC = new LinkedList<>();
		saveR.add(r);
		saveC.add(c);
		area[r][c] = 2; //왔던곳은 2
		
		while(!saveR.isEmpty()) {
			int nowR = saveR.poll();
			int nowC = saveC.poll();
			
			for(int k=0; k<8; k++) {
				int nextR = nowR +dr[k];
				int nextC = nowC +dc[k];
				
				if(nextR >= 0 && nextR < M && nextC >= 0 && nextC < N) {
					if(area[nextR][nextC] == 1) {
						saveR.add(nextR);
						saveC.add(nextC);
						area[nextR][nextC] = 2;
					}
				}
			}//k
		} 
	}
}
