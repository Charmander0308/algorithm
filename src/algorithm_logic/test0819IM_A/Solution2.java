package algorithm_logic.test0819IM_A;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			//1. 점수가 최소값이 되려면 오답이 무조건 카운터순서에 나와야한다.
			//2. 앞의 카운터순서보다 뒤의 카운터순서가 오답일 때 점수의 합이 더 낮아진다.
			
			int score = 0; //점수 담는용
			int counter = 0; //카운터 세는용
			int fail = N-M;	//오답 개수
			int maxCounter = 0;	//가능한 가장 높은 카운터 수
			//주어진 문제 중 가장 뒷순서의 카운터 문제번호를 구함
			for(int i = 1; i <= N; i++) {
				if(i % K == 0) {
					maxCounter += K;
				}
			}
//			System.out.println(maxCounter);
			//maxCounter 수 담기(오답이 2개 이상인 경우를 위해 배열로 담음)
			int[] maxCounters = new int[fail];
			//오답 개수만큼 뒤에서부터 카운터 문제번호를 배열에 담음
			for(int i = 0; i < fail; i++){
				maxCounters[i] = maxCounter;
				//문제번호는 음수가 될 수 없음
				if(maxCounter - K > 0) {
					maxCounter -= K;
				} 
				//문제 번호가 0이하가 되는 경우
				else {
					//K미만까진 문제번호를 1씩 내려서 maxCounter에 담기 
					if(maxCounter - 1 >= 0) {
						maxCounter--;
					} 
					//그래도 안되면(정말 극단적인 케이스) 총점수를 깎음
					else {
						score--;
					}
				}
			}
			System.out.println(Arrays.toString(maxCounters));
			System.out.println(counter);
			
			//문제 순회하며 점수 계산하기
			for(int i = 1; i <= N; i++) {
				boolean isOk = true;	

				//현재 문제 번호가 maxCounters인 경우
				for(int j = 0; j < maxCounters.length; j++) {
					if(i == maxCounters[j]) {
						counter = 0;
						isOk = false;
					}
				}
				//maxCounter인 경우였으면 패스
				if(isOk == false) {
					continue;
				} 
				//보편적인 정답의 경우 (그냥 else로 해도 되는데 긴장했나봄)
				else if(isOk == true) {
					score++;	//점수 1 획득
					counter++;	//카운터 1 증가
					//문제번호가 K인 경우(2배 이벤트)
					if(i % K == 0) {	//시험지엔 (i == k)로 적어서 망했습니다,,,
						score *= 2;	//점수두배
						counter = 0;	//카운터 리셋
					}
				}
				System.out.println(i + "번째 문제===");
				System.out.println("score = " + score);
			}
			
			System.out.println("#" + test_case + " " + score);
		}
	}
}
