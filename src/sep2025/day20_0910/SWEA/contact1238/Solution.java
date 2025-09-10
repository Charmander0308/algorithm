package sep2025.day20_0910.SWEA.contact1238;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static boolean[] visited;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day20_0910/SWEA/contact1238/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();	//입력받을 데이터의 길이 (ex:24면 from 12 + to 12)
			int start = sc.nextInt();	//시작점
			 List<Integer>[] cont = new ArrayList[101];	//1~100까지 숫자들의 연결점들을 담는 배열
			 visited = new boolean[101];
			 for(int i=0; i<cont.length; i++) {
				 cont[i] = new ArrayList<>();
			 }
			 
			 for(int i=0; i<N/2; i++) {
				 int from = sc.nextInt();
				 int to = sc.nextInt();
				 
				 cont[from].add(to);
			 }
//			 System.out.println(Arrays.toString(cont));
			 
			 List<Integer> answer = new ArrayList<>();
			 Queue<Integer> pq = new ArrayDeque<>();
			 pq.add(start);
			 visited[start] = true;
			 
			 while(!pq.isEmpty()) {
				 answer.clear();
				 int size = pq.size();
				 for(int i=0; i<size; i++) {
					 int now = pq.poll();
					 answer.add(now);
					 
					 for(int j=0; j<cont[now].size(); j++) {
						 int n = cont[now].get(j);
						 if(!visited[n]) {
							 pq.add(n);
							 visited[n] = true;
						 }
					 }
				 }
//				 System.out.println(answer);
			 }
			 System.out.println("#" + test_case + " " + Collections.max(answer));
		}
		
	}

}
