package sep2025.day31_0923.BOJ.shortest1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Edge>[] adj;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());	//정점의 개수
		E = Integer.parseInt(st.nextToken());	//간선의 개수
		int K = Integer.parseInt(br.readLine());	//시작정점 번호
		
		adj = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[V+1];		//해당정점까지 오는 가장 최단 거리
		visited = new boolean[V+1];
		
		Arrays.fill(dist, INF);
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adj[from].add(new Edge(to, cost));
		}
		
		dijkstra(K);
		for(int i=1; i<V+1; i++) {
			if(dist[i] == INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		
	}

	private static void dijkstra(int start) {
		dist[start] = 0;
		for(int i=1; i<=V; i++) {
			int min = INF;
			int idx = -1;
			for(int j=1; j<=V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			
			if(idx == -1) break;
			
			visited[idx] = true;
			
			for(Edge e : adj[idx]) {
				if(!visited[e.to] && dist[e.to] > dist[idx] + e.cost) {
					dist[e.to] = dist[idx] + e.cost;
				}
			}
			
		}
	}
}
