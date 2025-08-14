package day09_0814.etc.rollball;

import java.util.Scanner;

public class Main {
	
	//상 우 하 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//최대이동
			int maxMove = 0;
			//이동횟수 담기
			int move = 1;
			
			//모든 칸 확인
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					
					//현재 좌표를 기억하기 위한 변수
					int nowR = r;
					int nowC = c;
					int nowHeight = arr[nowR][nowC]; 
					
					//반복 고고
					while(true) {
						//최소값일때 담을 공간들
						int minR = -1;
						int minC = -1;
						int min = 501;
						//상 우 하 좌 탐색
						for(int k = 0; k < 4; k++) {
							int nextR = nowR + dr[k];
							int nextC = nowC + dc[k];
							
							//배열 안 벗어나는지 확인
							if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
								int nextHeight = arr[nextR][nextC]; 
								
								//min에 최소값 찾아서 넣기
								//현재 높이보다 낮은지 확인
								if(nextHeight < nowHeight) {
									//가장 낮은 높이라면 최저값 갱신
									if(arr[nextR][nextC] < min) {
										min = arr[nextR][nextC];
										minR = nextR;
										minC = nextC;
									}
								}
							}
						}
						//더이상 최소값이 없으면 종료
						if(min == 501) {
							break;
						} 
						//포인터 이동
						nowR = minR;
						nowC = minC;
						nowHeight = arr[nowR][nowC];
						
						//이동 1증가
						move++;
					}
	//				System.out.println(nowR + "," + nowC + "= " + move);
					//최고기록 갱신?
					if(move > maxMove) maxMove = move;
	//				System.out.println(maxMove);
					
					//다음칸 확인위해 초기화
					move = 1;
				}
			}
			System.out.println("#" + test_case + " " + maxMove);
		}
	}

}
