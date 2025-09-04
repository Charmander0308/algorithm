package sep2025.day17_0904.SWEA.hamster8275;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Archive {
		int l;	//시작 우리
		int r;	//종료 우리
		int s;	//범위 내의 마리수
		
		public Archive(int l, int r, int s) {
			this.l = l;
			this.r = r;
			this.s = s;
		}
	}
	
	static List<Archive> archList;
	static int[] cage;
	static int[] answerCage;
	static int answerCount;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		File file = new File("src/sep2025/day17_0904/SWEA/hamster8275/sample_input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	//햄스터 우리 개수
			int X = Integer.parseInt(st.nextToken());	//우리 당 최대 햄스터 수
			int M = Integer.parseInt(st.nextToken());	//경근이가 남긴 Archive 수
			
			archList = new ArrayList<>();	//기록물 저장소
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());	//시작 우리
				int r = Integer.parseInt(st.nextToken());	//종료 우리
				int s = Integer.parseInt(st.nextToken());	//범위 내의 마리수
				
				archList.add(new Archive(l, r, s));	//저장저장
			}
			
			cage = new int[N+1]; 
			answerCage = new int[N+1]; 
			answerCount = N*X;
			visited = new boolean[N+1];
			
			dfs(0, M, 0, X);
			
			
			
		}
	}
	
	//(기록물 번호, 전체 기록물 수, 현재 햄스터 총 마리수, 
	static void dfs(int archNum, int M, int currHams, int maxHams) {
		//기록물 다보면 재귀 종료
		if(archNum >= M) {
			//조건에 없었던 우리는 최대 마리수로 채우기 + 총 마리수에도 추가
			for(int i=1; i<cage.length+1; i++) {
				if(!visited[i]) {
					cage[i] = maxHams;
					currHams += cage[i];
				}
			}
			//조건1 : 마리수가 가장 많은 경우를 정답으로 함
			if(currHams > answerCount) {
				answerCount = currHams;
				System.arraycopy(archList, 0, answerCage, 0, cage.length);
			} 
			//조건2 : 마리수가 같다면 배열의 1번 인덱스부터 대소비교. 앞순서가 더 작은 경우를 정답으로 함
			else if(currHams == answerCount) {
				for(int i=1; i<cage.length+1; i++) {
					if(cage[i] != answerCage[i]) {
						
					}
				}
			}
			
			return;
		}
		
		
		
		
		
	}
	
}
