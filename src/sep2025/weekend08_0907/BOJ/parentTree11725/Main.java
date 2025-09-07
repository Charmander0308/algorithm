package sep2025.weekend08_0907.BOJ.parentTree11725;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer>[] adjList = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			adjList[node1].add(node2);
			adjList[node2].add(node1);
		}
		
		int[] parentNode = new int[N+1];
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int neighbor : adjList[curr]) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					parentNode[neighbor] = curr;
					queue.add(neighbor);
				}
			}
		}
		for(int i=2; i<=N; i++)
			System.out.println(parentNode[i]);
		
	}
}
