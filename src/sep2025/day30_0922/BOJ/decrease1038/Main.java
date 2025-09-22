package sep2025.day30_0922.BOJ.decrease1038;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		List<Long>[][] nums = new ArrayList[11][10];
		for(int i=0; i<11; i++) {
			for(int j=0; j<10; j++) {
				nums[i][j] = new ArrayList<>();
			}
		}
		
		//감소하는 수의 배열을 만들어보자
		for(int i=0; i<11; i++) {
			for(int j=i; j<10; j++) {
				//0행은 j를 넣기
				if(i == 0) {
					nums[i][j].add((long) j);
				}
				//1행부턴 연산
				else {
					//바로 위의 행의 시작부터 현재 열 인덱스 전까지의 값을 이용하여 연산해서 배열에 추가해주기
					for(int k=i-1; k<j; k++) {
						for(int l = 0; l<nums[i-1][k].size(); l++) {
							long n = (long) (Math.pow(10, i)*j + nums[i-1][k].get(l));
							nums[i][j].add((long) n);
						}
					}
				}
			}
		}
		//잘 들어갔는지 확인
//		for(int i=0; i<11; i++) {
//			System.out.println(Arrays.toString(nums[i]));
//		}
		
		//카운팅변수
		int cnt = 0;
		//정답변수(답이 없으면 -1출력)
		long ans = -1;
		//N번째 감소수를 찾아보자~
		home : 
		for(int i=0; i<11; i++) {
			for(int j=0; j<10; j++) {
				//빈 리스트면 넘김
				if(nums[i][j] == null) continue;
				//인덱스만큼 돌기
				for(int k=0; k <nums[i][j].size(); k++) {
					//찾으면 정답변수에 해당 인덱스값 넣고 반복 종료!
					if(cnt == N) {
						ans = nums[i][j].get(k);
						break home;
					}
					cnt++;
				}
			}
		}
		System.out.println(ans);
		
	}
}
