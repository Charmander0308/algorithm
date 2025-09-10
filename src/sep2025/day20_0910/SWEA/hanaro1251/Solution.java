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

	
	static class Node implements Comparable<Node>{
		int to;
		long dist;	//정확한 거리값말고 제곱인 그대로 받아두기 

		public Node(int to, long dist) {
			this.to = to;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.dist, o.dist);	//고급기술...걍 외우자 
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
					long dist = 0;
					//경우 나눌 필요없이, 어차피 다 똑같이 계산됨...ㅠ
					dist = (long) (Math.pow(width, 2) + Math.pow(height, 2));
					//무향이니까 다 넣어주자 
					edges[i].add(new Node(j, dist));
					edges[j].add(new Node(i, dist));
				}
			}
			
//			System.out.println(edges);
			
			//프림을 써보자
			boolean[] visited = new boolean[N];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			long ans = 0;
		
			int pick = 0;	//(노드수-1) 만큼 고르면 종료할거야~ 
			visited[0] = true;	//시작노드는 방문처리~
			for(Node n : edges[0]) pq.add(n);	//시작노드랑 연결된 다른노드들 다 넣기 
			
			//다 찾기 전까지 반복~
			while(pick < N-1) {
				Node n = pq.poll();	//우선순위큐라서 제일 최소값부터 알아서 찾게된다.
				if(visited[n.to]) continue;	//이미 처리된곳은 패스 
				
				ans += n.dist;	//dist를 정답에 추가 
				visited[n.to] = true;	//방문처리!
				pick++;	//하나 골랐슈~
				
				pq.addAll(edges[n.to]);	//연결된 노드들 다 pq에 넣기(반복)
			}
			double totalAns = ans * E;	//다 더해진 값에 환경부담세율 곱해주기..
			System.out.println("#" + test_case + " " + Math.round(totalAns));	//반올림해서 출력 
			
		}
	}
}
