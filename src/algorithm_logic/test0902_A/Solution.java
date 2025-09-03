package algorithm_logic.test0902_A;

import java.util.Scanner;

public class Solution {
	// turn[방향][사분면의 회전수]
	//방향 -> 0:동, 1:남, 2:서, 3:북 으로 생각
	static int[][] turn = {
			{1, 2, 3, 3},
			{3, 1, 2, 3},
			{3, 3, 1, 2},
			{2, 3, 3, 1}
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] area = new int[N][N];
			
			int M = 0;	//사과 개수
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					area[i][j] = sc.nextInt();
					if(area[i][j] > M) M = area[i][j];	//가장 높은 번호가 사과 개수와 동일
				}
			}
			//사과들의 r,c 값
			int[] mr = new int[M];
			int[] mc = new int[M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int num = area[i][j];
					//사과들의 r,c 저장 (ex: 1번사과의 r,c 는 0번 인덱스에 저장)
					if(num != 0) {
						mr[num-1] = i;
						mc[num-1] = j;
					}
				}
			}
			//현재 위치
			int r = 0, c = 0;
			int dir = 0; //0:동, 1:남, 2:서, 3:북 으로 생각
			int target = 0;	//현재 목표사과(인덱스)
			int count = 0;	//총 회전 횟수
			//다 찾기 전까지 반복
			while(target != M) {
				//사과가 현재기준 어떤 사분면에 있나요?
				int nr = mr[target] - r;
				int nc = mc[target] - c;
				
				//4사분면(남동쪽)
				if(nr > 0 && nc > 0) {
					//현재 방향일때 필요한 회전수만큼 총 회전수에 더한다
					count += turn[dir][0];
					//방향은 회전수에 영향을 받는다. 이하 동일
					dir = (dir + turn[dir][0]) % 4;
				}
				//3사분면(남서쪽)
				else if(nr > 0 && nc < 0) {
					count += turn[dir][1];
					dir = (dir + turn[dir][1]) % 4;
				}
				//2사분면(북서쪽)
				else if(nr < 0 && nc < 0) {
					count += turn[dir][2];
					dir = (dir + turn[dir][2]) % 4;
				}
				//1사분면(북동쪽)
				else if(nr < 0 && nc > 0) {
					count += turn[dir][3];
					dir = (dir + turn[dir][3]) % 4;
				}
				//사과 위치로 순간이동
				r = mr[target];
				c = mc[target];
				//다음 사과로 목표(인덱스) 이동
				target++;
			}
			//몇 번 돌았니
			System.out.println("#" + test_case + " " + count);
			
		}
		
	}

}
