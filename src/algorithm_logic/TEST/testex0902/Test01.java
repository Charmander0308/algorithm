package algorithm_logic.TEST.testex0902;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/algotest/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
//			System.out.println(tc + "번===================");
			int N = sc.nextInt();	//한 변의 길이
			int X = sc.nextInt();	//경사로의 가로길이
			int[][] area = new int[N][N];
			//배열 받기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					area[i][j] = sc.nextInt();
				}
			}
			int answer = 0;
			for(int i=0; i<N; i++) {
				int pointer = 0;	//현재 위치
				int count = 0;		//지금까지 평지의 수
				boolean isOk = true;	//활주로 가능이라고 가정
				
				for(int j=0; j<N; j++) {
					//첫번째 땅은 판단하지 않음(기준으로 설정하고 시작)
					if(j == 0) {
						pointer = area[i][j];
						count++;
					} 
					//두번째 땅부터 판단하기
					else {
						//2칸 이상 높아지면 불가
						if(Math.abs(area[i][j]-pointer) > 1) {
							isOk = false;
							break;
						}
						//전보다 경사가 올라간 경우
						if(area[i][j] > pointer) {
							//이전까지의 평지의 수가 경사로 가로길이보다 적으면 불가 
							if(count < X) {
								isOk = false;
								break;
							}
							//경사로 설치 가능하다면 포인터를 해당 높이로 설정하고 다시 평지 수 세기
							else {
								count = 1;
								pointer = area[i][j];
							}
						} 
						//경사가 내려간 경우
						else if(area[i][j] < pointer) {
							//
							if(count < 1) {
								isOk = false;
								break;
							}
							count = 1-X+1;
							pointer = area[i][j];
						}
						//평평한 경우
						else {
							count++;
						}
					}
					
					if(j == N-1 && count < 1) {
						isOk = false;
					}
				}
				if(isOk == true) answer++;
				
//				System.out.println(i+1 + "번째줄 = " + answer);
			}
			
			for(int i=0; i<N; i++) {
				int pointer = 0;
				int count = 1;
				boolean isOk = true;
				
				for(int j=0; j<N; j++) {
					if(j == 0) {
						pointer = area[j][i];
					} else {
						if(Math.abs(area[j][i]-pointer) > 1) {
							isOk = false;
							break;
						}
						//전보다 경사가 올라간 경우
						if(area[j][i] > pointer) {
							if(count < X) {
								isOk = false;
								break;
							} else {
								count = 1;
								pointer = area[j][i];
							}
						} 
						//경사가 내려간 경우
						else if(area[j][i] < pointer) {
							//남은 평지 수가 1미만인데 내려간 경우 -> 경사로가 아직 안끝났는데 또 내려간경우
							if(count < 1) {
								isOk = false;
								break;
							}
							//새로 갱신 + 경사로 길이만큼 카운트를 빼둠 + 경사로 1만큼 지나감
							count = 1-X+1;
							pointer = area[j][i];
						}
						//평평한 경우
						else {
							count++;
						}
					}
					//경사로가 안끝났는데 배열이 끝난 경우 불가
					if(j == N-1 && count < 1) {
						isOk = false;
					}
				}
				if(isOk == true) answer++;
				
//				System.out.println(i+1 + "번째줄 = " + answer);
			}
			
			System.out.println("#" + tc + " " + answer);
			
			
		}
	}
}
