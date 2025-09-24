package sep2025.day32_0924.BOJ.minimumCost1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int INF = Integer.MAX_VALUE;
	static int N, M;
	static List<Edge>[] adj;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//도시의 개수
		M = Integer.parseInt(br.readLine());	//버스의 개수
		dist = new int[N+1];	//간선 최소거리 배열
		visited = new boolean[N+1];	//방문여부 저장배열
		//간선정보 리스트배열
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
			dist[i] = INF;
		}
		//간선정보 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adj[from].add(new Edge(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());	//출발점
		int end = Integer.parseInt(st.nextToken());		//도착점
		
		dijkstra(start);
		System.out.println(dist[end]);
		
	}

	private static void dijkstra(int start) {
		dist[start] = 0;
		for(int i=0; i<N; i++) {
			int min = INF;
			int idx = -1;
			for(int j=1; j<=N; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			if(idx == -1) break;	//더 갈 곳 없으면 종료
			
			visited[idx] = true;	//방문처리
			
			for(Edge e: adj[idx]) {
				if(!visited[e.to] && dist[e.to] > dist[idx] + e.cost) {
					dist[e.to] = dist[idx] + e.cost;
				}
			}
		}
		
		
	}
}
