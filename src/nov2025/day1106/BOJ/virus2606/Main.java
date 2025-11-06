package nov2025.day1106.BOJ.virus2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//총 컴퓨터의 수
		int comCnt = Integer.parseInt(br.readLine());
		//쌍의 수
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] network = new List[comCnt+1];
		for(int i=1; i<=comCnt; i++) {
			network[i] = new ArrayList<>();
		}
		//양방향 연결 그래프
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
//			System.out.println(start + ", " + end);
			network[start].add(end);
			network[end].add(start);
		}
		//감염여부 체크(중복탐색 방지)
		boolean[] isInfected = new boolean[comCnt+1];
		Queue<Integer> q = new ArrayDeque<>();
		
		//1번이 감염됐다!
		q.offer(1);
		isInfected[1] = true;
		//감염 컴 수
		int answer = 0;
		//연결된 컴이 다 감염될때까지 감염시켜라!
		while(!q.isEmpty()) {
			int com = q.poll();
			for(int i=0; i<network[com].size(); i++) {
				int connectedCom = network[com].get(i);
				//감염이 안됐다면 감염시키자!
				if(!isInfected[connectedCom]) {
					isInfected[connectedCom] = true; //감염 완
					answer++;	//감염된 컴수 증가
					q.add(connectedCom);	//너도 다른걸 감염시키자!
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
