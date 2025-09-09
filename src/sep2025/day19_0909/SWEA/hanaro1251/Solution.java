package sep2025.day19_0909.SWEA.hanaro1251;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, V;	//섬(노드)의 개수, 간선 개수
	static int[] p;		//루트 노드가 무엇인가요
	
	static class Node {
		int from, to;
		double dist;

		public Node(int from, int to, double dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", dist=" + dist + "]";
		}
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day19_0909/SWEA/hanaro1251/re_sample_input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();	//섬의 개수
			V = sum(N-1);	//간선의 개수
			int[][] islands = new int[N][2];	//[0]: r, [1]: c
			//섬 위치 담기
			for(int i=0; i<2; i++) {
				for(int j=0; j<N; j++) {
					islands[j][i] = sc.nextInt();
				}
			}
			Node[] nodes = new Node[V];	//모든 간선의 경우를 담자 
			int idx = 0;
			
			double E = sc.nextDouble();	//환경부담 세율 (환경부담금 = E * L^2)
			
			//nodes[] 를 채워보자
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					//임의의 섬1, 섬2의 좌표
					int x1 = islands[i][0];
					int y1 = islands[i][1];
					int x2 = islands[j][0];
					int y2 = islands[j][1];
					
					//두 섬의 간선이 대각선일 때
					if(x1 != x2 && y1 != y2) {
						int line1 = Math.abs(x1-x2);
						int line2 = Math.abs(y1-y2);
						double dist = Math.sqrt(Math.pow(line1, 2) + Math.pow(line2, 2));	//피타고라스로 대각선 거리 구하기
						nodes[idx] = new Node(i, j, dist);	//간선 정보 저장하기!
					}
					//두 섬이 수직으로 있을 때
					else if(x1 == x2 && y1 != y2) {
						double dist = Math.abs(y1-y2);
						nodes[idx] = new Node(i, j, dist);	
					}
					//두 섬이 수평으로 있을 때
					else if(y1 == y2 && x1 != x2) {
						double dist = Math.abs(x1-x2);
						nodes[idx] = new Node(i, j, dist);
					}
					idx++;	//다음 인덱스로~
				}
			}
//			System.out.println(Arrays.toString(nodes));
			//dist낮은 순으로(가까운순) 간선정보 정렬하기
			Arrays.sort(nodes,(n1, n2) -> Double.compare(n1.dist, n2.dist));
//			System.out.println(Arrays.toString(nodes));
			double answer = 0;
			int count = 0;
			makeSet(N);
			
			//크루스칼까지 오는게 더어렵다
			for(int i=0; i<V; i++) {
				boolean ans = union(nodes[i].from, nodes[i].to);
				//true가 리턴되면 간선이 하나 추가된거니 정답에 환경부담금 더하고 count 1추가
				if(ans == true) {
					answer += E * Math.pow(nodes[i].dist, 2);
					count++;
				}
				if(count == N-1) break;	//간선 다 찾으면 반복 종료
			}
			
			System.out.println("#" + test_case + " " + Math.round(answer));
			
			
		}
		
	}
	//총 간선수(V) 구하는 용
	static int sum(int n) {
		if(n == 1) return 1;
		return n + sum(n-1);
	}
	
	static void makeSet(int n) {
		p = new int[N];
		for(int i=0; i<n; i++) {
			p[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(x == p[x]) return p[x];
		return p[x] = findSet(p[x]);
	}
	
	static boolean union(int x, int y) {
		int rx = findSet(x);
		int ry = findSet(y);
		
		if(rx != ry) {
			p[ry] = rx;	//간선 하나가 유효로 추가된거!
			return true;
		}
		return false;
	}
	

}
