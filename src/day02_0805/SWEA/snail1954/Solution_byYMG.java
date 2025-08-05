package day02_0805.SWEA.snail1954;

import java.io.File;
import java.util.Scanner;

public class Solution_byYMG {
	public static void main(String[] args) throws Exception {
		File file = new File("src/day02_0805/SWEA/snail1954/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int k = N;	//이동할 칸의 수
			int D = 1;	//증감 1-> -1 -> 1
			//현재 좌표
			int r = 0;
			int c = -1;
			int num = 1;
			
			//반복문을 수행하면서 처리하자~
			while(true) {
				//수평 -> 수직 : 이동거리가 1 줄어든다
				for(int i = 0; i < k; i++) {
					c += D;	//때로는 1, 때로는 -1
					arr[r][c] = num++;
				}	//수평을 채웠다...
				k--;
				
				//종료조건 
				//1. k == 0 : 더이상 이동 불가
				//2. (r, c) : 중앙좌표일 때(주의 필요)
				//3. num == NxN
				if(k == 0) break;	//종료조건
				
				//수직 -> 수평 : 증감의 방향이 바뀐다
				for(int i = 0; i < k; i++) {
					r += D;
					arr[r][c] = num++;
				}	//수직을 채웠다...
				D = -D;
			}//달팽이 채우기
			
			System.out.println("#" + test_case);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}

}
