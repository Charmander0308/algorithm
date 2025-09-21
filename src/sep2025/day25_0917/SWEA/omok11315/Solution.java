package sep2025.day25_0917.SWEA.omok11315;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static char [][] arr;
	static int N;
	static String ans;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day0917/SWEA/omok11315/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			
			arr = new char[N][N];
			for(int i=0; i<N; i++) {
				String line = sc.next();
				for(int j=0; j<N; j++) {
					arr[i][j] = line.charAt(j);
				}
			}
			
//			for(int i=0; i<N; i++)
//				System.out.println(Arrays.toString(arr[i]));
			
			ans = "NO";
			search(0, 0);
			System.out.println("#" + test_case + " " + ans);
			
		}
	}
	
	static void search(int r, int c) {
		if(r == N)
			return;
		//열 끝까지 왔다면 아랫줄 0번열로 이동
		if(c == N) {
			search(r+1, 0);
			return;
		}
		
		if(arr[r][c] == 'o') {
			for(int i=0; i<8; i++) {
				//둘 한개는 일단 세기
				int count = 1;
				for(int j=1; j<=N; j++) {
					int nr = r + (dr[i] * j);
					int nc = c + (dc[i] * j);
					
					//배열범위를 벗어나거나, o가 아니라면 다음 방향 탐색
					if(nr<0 || nr>=N || nc<0 || nc>=N || arr[nr][nc] != 'o') {
						break;
					}
					count++;
					//돌이 같은 방향으로 연속 5개이상이면 찾았음
					if(count == 5) {
						ans = "YES";
					}
				}
			}
		}
		//우로 한칸 이동
		search(r, c+1);
		
	}
	
}
