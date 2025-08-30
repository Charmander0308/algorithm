package aug2025.weekend05_0830.baekjoon.guard2564;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();
		int N = sc.nextInt();	//상점 개수
		
		int[][] stores = new int[N][2];
		for(int i=0; i<N; i++) {
			stores[i][0] = sc.nextInt();	//상점 방향 
			stores[i][1] = sc.nextInt();	//상점 거리 
		}
		int[] donggeun = {sc.nextInt(), sc.nextInt()};	//동근 방향, 동근 거리
		
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			//동근이랑 같은 방향인 경우
			if(stores[i][0] == donggeun[0]) {
				answer += Math.abs(stores[i][1] - donggeun[1]);
			}
			//동근이와 다른 방향인 경우
			else {
				if(donggeun[0] <= 2) {
					//동근이와 마주보는 방향인 경우 
					if(stores[i][0] <= 2) {
						answer += Math.min(height + stores[i][1] + donggeun[1] , height + (width - stores[i][1]) + (width - donggeun[1]));
					}
					// 수직방향인 경우 
					else {
						if(donggeun[0] == 1) {
							if(stores[i][0] == 3) {
								answer += (donggeun[1] + stores[i][1]);
							} else if(stores[i][0] == 4) {
								answer += ((width - donggeun[1]) + stores[i][1]);
							}
						} else if(donggeun[0] == 2) {
							if(stores[i][0] == 3) {
								answer += (donggeun[1] + (height - stores[i][1]));
							} else if(stores[i][0] == 4) {
								answer += ((width - donggeun[1]) + (height - stores[i][1]));
							}
						}
					}
				} else {
					if(stores[i][0] >= 3) {
						answer += Math.min(width + stores[i][1] + donggeun[1] , width + (height - stores[i][1]) + (height - donggeun[1]));
					} else {
						if(donggeun[0] == 3) {
							if(stores[i][0] == 1) {
								answer += (donggeun[1] + stores[i][1]);
							} else if(stores[i][0] == 2) {
								answer += ((height - donggeun[1]) + stores[i][1]);
							}
						} else if(donggeun[0] == 4) {
							if(stores[i][0] == 1) {
								answer += (donggeun[1] + (width - stores[i][1]));
							} else if(stores[i][0] == 2) {
								answer += ((height - donggeun[1]) + (width - stores[i][1]));
							}
						}
					}
				}
				
			} //end if
		} //for
		
		System.out.println(answer);
		
	}
}
