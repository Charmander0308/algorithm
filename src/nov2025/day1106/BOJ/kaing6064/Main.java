package nov2025.day1106.BOJ.kaing6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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
			nowY = x % N;
			
			//2. nowY가 y가 될때까지 or y가 나온게 또 나올때까지 반복
			int startY = nowY;
			while(true) {
				int nextY = (nowY + M) % N;
				//사이클이 생기면 무한루프 도니까(해가 없는경우) 종료
				if(nextY == startY) break;
				else {
					nowY = nextY;
					year += M;
				}
				//주어진 x,y에 도달했다면 종료
				if(nowY == y) {
					answer = year;
					break;
				}
			}
			
			System.out.println(answer);
			
		}
	}
}
