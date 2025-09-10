package sep2025.day20_0910.SWEA.hanaro1251;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//프림을 활용하여 풀어보자!
public class Solution {
	static int N, L;	//섬 수, 간선 수
	static final int INF = Integer.MAX_VALUE;	//무한

	
	static class Node {
		int to;
		double dist;

		public Node(int to, double dist) {
			this.to = to;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", dist=" + dist + "]";
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day20_0910/SWEA/hanaro1251/re_sample_input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int[][] loc = new int[N][2];	//0:x좌표, 1:y좌표
			
			//좌표 넣기
			for(int i=0; i<2; i++) {
				for(int j=0; j<N; j++) {
					loc[j][i] = sc.nextInt();
				}
			}
			
			//부담세율 받기
			double E = sc.nextDouble();
			
			//그래프 정보 담기
			List<Node>[] edges = new ArrayList[N];
			for(int i=0; i<N; i++) {
				edges[i] = new ArrayList<>();
			}
			
			//그래프를 그리자
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					int x1 = loc[i][0];
					int y1 = loc[i][1];
					int x2 = loc[j][0];
					int y2 = loc[j][1];
					
					int width = Math.abs(x1 - x2);
					int height = Math.abs(y1 - y2);
					double dist = 0;
					//대각선으로 위치한 경우
					if(width != 0 && height != 0) {
						dist = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
					}
					//수직으로 위치한 경우
					else if(width == 0 && height != 0) {
						dist = height;
					}
					//수평으로 위치한 경우
					else if(height == 0 && width != 0) {
						dist = width;
					}
					edges[i].add(new Node(j, dist));
				}
			}
			
//			System.out.println(edges);
			
			//프림을 써보자
			int[] p = new int[N];
			int[] key = new int[N];
			boolean[] visited = new boolean[N];
			
			for(int i=0; i<N; i++) {
				key[i] = INF;
			}
			Arrays.fill(p, -1);
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			key[0] = 0;
			
			while(!pq.isEmpty()) {
				
				
				
			}
			
			
			
			
			
			
			
		}
	}
}
