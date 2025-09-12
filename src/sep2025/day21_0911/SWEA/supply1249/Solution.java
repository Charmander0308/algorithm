package sep2025.day21_0911.SWEA.supply1249;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int INF = Integer.MAX_VALUE;
	static int[] dr = {-1, 0 ,1 ,0};
	static int[] dc = {0, 1, 0, -1};
	
	//좌표
	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	//간선정보
	static class Edge {
		Loc to;
		int cost;

		public Edge(Loc to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int N;	//지도 한 변의 길이
	static int[][] holeDepth;	//구덩이 깊이
	static List<Edge>[][] adj;	//인접리스트
	static int[][] dist; //걸리는 거리
	static boolean[][] visited;	//방문체크
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day21_0911/SWEA/supply1249/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			//기본 세팅
			N = sc.nextInt();	//맵 사이즈
			adj = new ArrayList[N][N];	//인접한 간선 리스트
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					adj[i][j] = new ArrayList<>();
				}
			}
			dist = new int[N][N];	//출발지부터 여기까지 최단거리
			visited = new boolean[N][N];	//여길 온적이 있나요?
			
			//구덩이 깊이 넣기
			for(int i=0; i<N; i++) {
				String line = sc.next();
				for(int j=0; j<N; j++) {
					holeDepth[i][j] = line.charAt(j)-'0';
				}
			}
			//간선 리스트 채우기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					
					
					
				}
			}
		}
	}

	static void dijkstra() {

	}
	
}
