package nov2025.day1106.BOJ.kaing6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int test_case=1; test_case <=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int answer = -1;

			int nowX = 1, nowY = 1;
			int year = 1;
			
			//1. x기준으로 nowX, nowY를 맞추기
			year += (x - nowX);
			nowX = x;
			nowY = x;
			
			int k = Math.abs(M-N);
			int n = Math.abs(y - nowY);
			if((n + N) % k == 0) {
				if(n % k == 0) {
					year += ((n/k) * M);
				} else {
					year += (((n+N)/k) * M);
				}
				
				answer = year;
			}
			
			System.out.println(answer);
			
		}
	}
}
