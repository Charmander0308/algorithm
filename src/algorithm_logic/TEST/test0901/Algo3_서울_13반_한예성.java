package algorithm_logic.TEST.test0901;

import java.util.Scanner;

public class Algo3_서울_13반_한예성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String [][] arr = new String[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					arr[i][j] = sc.next();
				}
			}
			int answer = 0;
			//회문의 길이(전체일경우부터 1씩 줄어듦)
			for(int i=N; i>0; i--) {
				boolean isOk = true;
				//회문의 비교 시작점
				for(int j=0; j<N-i+1; j++) {
					//회문의 비교 종료구간
					for(int h=j; h<=N/2; h++) {
						//배열 내의 문자열 비교
						for(int k=0; k<M; k++) {
							if(arr[h][k] != arr[N-h-1][k]) {
								isOk = false;
								break;
							}
						}
						if(isOk == false) break;
					}
					if(isOk == false) break;
				}
				if(isOk == true) {
					answer = i;
					break;
				}
			}
			
			System.out.println(answer);
			
		}
		
	}
}
