package aug2025.weekend06_0831.baekjoon.warehouse2304;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] pillars = new int[N][2];
		
		// 1. 기둥 정보 입력받기
		for(int i=0; i<N; i++) {
			pillars[i][0] = sc.nextInt(); // 위치 (L)
			pillars[i][1] = sc.nextInt(); // 높이 (H)
		}
		
		// 2. 위치(L)를 기준으로 기둥 정렬
		Arrays.sort(pillars, (o1, o2) -> {
			return o1[0] - o2[0];
		});

		// 3. 가장 높은 기둥의 높이와 인덱스 찾기
		int highest = 0;
		int highestIdx = 0;
		for(int i=0; i<N; i++) {
			if(pillars[i][1] > highest) {
				highest = pillars[i][1];
				highestIdx = i;
			}
		}
		
		int totalArea = 0;
		
		// 4. 왼쪽 -> 가장 높은 기둥까지 면적 계산
		// 왼쪽 끝 기둥부터 시작
		int currentMaxHeight = pillars[0][1];
		for(int i = 1; i <= highestIdx; i++) {
			int width = pillars[i][0] - pillars[i-1][0];
			totalArea += width * currentMaxHeight;
			// 현재 기둥이 더 높으면, 다음 면적 계산을 위해 최대 높이를 갱신
			currentMaxHeight = Math.max(currentMaxHeight, pillars[i][1]);
		}
		
		// 5. 오른쪽 -> 가장 높은 기둥까지 면적 계산
		// 오른쪽 끝 기둥부터 시작
		currentMaxHeight = pillars[N-1][1];
		for(int i = N - 2; i >= highestIdx; i--) {
			int width = pillars[i+1][0] - pillars[i][0];
			totalArea += width * currentMaxHeight;
			// 현재 기둥이 더 높으면, 다음 면적 계산을 위해 최대 높이를 갱신
			currentMaxHeight = Math.max(currentMaxHeight, pillars[i][1]);
		}
		
		// 6. 가장 높은 기둥 자체의 면적(너비 1) 추가
		totalArea += highest;
		
		System.out.println(totalArea);
	}
}
