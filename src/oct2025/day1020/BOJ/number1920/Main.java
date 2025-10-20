package oct2025.day1020.BOJ.number1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N
		int N = Integer.parseInt(br.readLine());
		//N배열
		ArrayList<Integer> nArr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nArr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(nArr);
		//M
		int M = Integer.parseInt(br.readLine());
		//M만큼 요소 포함여부 체크
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int checkNum = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N-1;
			int answer = 0;
			while(true) {
				int criteria = (end - start +1)/2;
				int k = nArr.get(criteria + start);
				//찾으면 탈출
				if(k == checkNum) {
					answer = 1;
					break;
				}
				//다 찾아봐도 없으면 종료
				if(criteria <=0 || criteria >= N-1) break;
				//못찾으면 범위 조정
				if(k > checkNum) {
					end = criteria; 
				} else if(k < checkNum) {
					start = criteria;
				}
				
			}
			System.out.println(answer);
		}
	}
}
