package weekend01_0809.baekjoon.yeongsik1592;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//총인원 
		int N = sc.nextInt();
		//게임이 종료되는 받은 횟수 
		int M = sc.nextInt();
		//몇번째 옆으로 던질것인가 
		int L = sc.nextInt();
		//총 던진 횟수 담기 
		int count = 0;
		//N의 길이를 가진 각자 공 받은 횟수 담는 배열 
		int[] ballCount = new int[N];
		//시작한 사람은 이미 1번 받은걸로 간주 
		ballCount[0]=0;
		//현재 공의 위치 
		int ballCheck = 0;
		//종료될 때까지 반복 
		while(true) {
			//받은 사람 횟수 1 추가 
			ballCount[ballCheck]++;
			//지금 받은 사람의 횟수가 M이 되었다면 반복 종료 
			if(ballCount[ballCheck] == M) {
				break;
			}
			//공 던진 총 횟수 1 추가 
			count++;
			//현재 공을 가진 사람의 공 받은 횟수가 홀수일때 
			if(ballCount[ballCheck] % 2 != 0) {
				//시계방향으로 L만큼 던짐 
				ballCheck = (ballCheck + L) % N;
			} else {	//짝수일때 
				//시계 반대방향으로 L만큼은 시계 방향으로 N-L과 같음 
				ballCheck = (ballCheck + (N-L)) % N;
			}
		}
		//정답 출력 
		System.out.println(count);
	}
}
