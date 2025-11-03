package nov2025.day1103.BOJ.budget2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	//지방의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] budget = new int[N];	//각 지방의 요청예산
		for(int i=0; i<N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(budget); 	//오름차순 정렬
		int M = Integer.parseInt(br.readLine());	//국가예산의 총액
		
		int max = 0;	//최대값
		int k = N;		//k로 N을 저장
		for(int i=0; i<N; i++) {
			int num = budget[i];	//하나 겟
			//해당 금액으로 다 줘도 될 정도의 요청예산이면 전액을 줌
			if(num*k <= M) {
				M -= budget[i];	//예산 줬다고 치자
				max = num;	//현재 최고기록
				k--;	//한 지역 줄었어요~			
			}
			//초과되는 예산이면 남은 지역도 다 초과니까 사이좋게 N빵
			else {
				max = M/k;	//엔빵하자(얘가 최고금액임)
				break;
			}
		}
		
		System.out.println(max);
		
	}
}
