package algorithm_logic.test0819IM_A;

import java.util.Scanner;

public class Solution3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			//가장 큰 나무
			int maxHeight = 0;
			//날짜
			int day = 0;
			//자라는 키 길이
			int grow = 0;
			//홀수날은 1, 짝수날은 2 자람
			
			//나무 높이 저장 + 가장 큰 나무 높이 저장
			int[] tree = new int[N];
			for(int i = 0; i < N; i++) {
				tree[i] = sc.nextInt();
				if(tree[i] > maxHeight) maxHeight = tree[i];
			}
			//가장 큰 나무와의 높이 차
			int[] gap = new int[N];
			//높이차의 합
			int totalGap = 0;
			for(int i = 0; i < N; i++) {
				gap[i] = maxHeight - tree[i];
				totalGap += gap[i];
			}
			
			boolean isOk = true;
			//높이차의 합이 0 되기 전까지 돌기
			while(totalGap != 0) {
//				System.out.println(day +"일차===");
//				System.out.println(Arrays.toString(gap));
//				System.out.println(totalGap);
				day++;	//아침이 밝았습니다
				//홀수날은 1, 짝수날은 2 자람
				if(day % 2 !=0) {
					grow = 1;
				} else if(day % 2 == 0){
					grow = 2;
				}
				for(int k = 0; k < N; k++) {
					if(gap[k] > 2) {
						gap[k] -= grow;
						totalGap -= grow;
						break;
					}
					if(k == N-1) {
						isOk = false;
					}
				}
				if(isOk == false) {
					//
					if(grow == 1) {
						for(int i = 0; i < N; i++) {
							if(gap[i] % 2 != 0 && gap[i] != 0) {
								gap[i] -= grow;
								totalGap -= grow;
								break;
							}
						}
					} else if(grow == 2) {
						for(int i = 0; i < N; i++) {
							if(gap[i] % 2 == 0 && gap[i] != 0) {
								gap[i] -= grow;
								totalGap -= grow;
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + day);

		}
	}
}
