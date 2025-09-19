package algorithm_logic.TEST.testex0902;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test01_2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/algotest/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int[][] area = new int[N][N];
			//배열 받기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					area[i][j] = sc.nextInt();
				}
			}
			int answer = 0;
			//가로 배열의 경우
			for(int i=0; i<N; i++) {
				if(isOk(area[i], N, X)) answer++;
			}
			
			//세로 배열의 경우
			for(int i=0; i<N; i++) {
				int[] col = new int[N];
				for(int j=0; j<N; j++) {
					col[j] = area[j][i];
				}
				if(isOk(col, N, X)) answer++;
			}
			System.out.println("#"+test_case+" "+answer);
		}
		
	}
	
	static boolean isOk(int[] arr, int N, int X) {
		int[] installed = new int[N];
		
		for(int i=0; i<N-1; i++) {
			int ramp = arr[i] - arr[i+1];
			
			//절벽은 안됨(경사 2이상)
			if(ramp > 1 || ramp < -1) {
				return false;
			}
			
			//오르막을 만남(현재를 포함한 그동안의 땅을 X만큼 조사)
			if(ramp == -1) {
				for(int j=0; j<X; j++) {
					if(i-j < 0 || arr[i] != arr[i-j] || installed[i-j] != 0) {
						return false;
					}
					installed[i-j] = 1;
				}
			}
			//내리막을 만남(현재 이후의 땅을 X만큼 조사)
			else if(ramp == 1) {
				for(int j=1; j<=X; j++) {
					if(i+j >= N || arr[i+1] != arr[i+j] || installed[i+j] != 0) {
						return false;
					}
					installed[i+j] = 1;
				}
			}
		}
		return true;
	}

}
