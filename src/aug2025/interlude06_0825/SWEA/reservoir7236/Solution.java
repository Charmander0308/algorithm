package aug2025.interlude06_0825.SWEA.reservoir7236;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/aug2025/interlude06_0825/SWEA/reservoir7236/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String[][] reservoir = new String[N][N];
			
			//입력받기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					reservoir[i][j] = sc.next();
				}
			}
			int max = 0;//가장 깊은 깊이
			//하나씩 탐색
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//해당영역이 땅이면 패스
					if(reservoir[i][j].equals("G")) {
						continue;
					} else if(reservoir[i][j].equals("W")) {
						int depth = 0;	//깊이 담는용
						//8방탐색
						for(int k=0; k<8; k++) {
							int nextR = i + dr[k];	
							int nextC = j + dc[k];
							//배열 내에 위치한다면 탐색
							if(nextR >=0 && nextR < N && nextC >= 0 && nextC < N) {
								if(reservoir[nextR][nextC].equals("W")) depth++;	//주위 1칸이 물일때마다 깊이 1추가
							}
						}
						if(depth == 0) depth = 1;	//깊이가 0이면 최소깊이인 1로 변경
						if(depth > max) max = depth;	//지금까지중 최고깊이면 갱신
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
			
		}
		
	}

}
