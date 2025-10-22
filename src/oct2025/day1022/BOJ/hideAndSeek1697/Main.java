package oct2025.day1022.BOJ.hideAndSeek1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int sec = 0;
		
		while(N != K) {
			int case1 = N-1;
			int case2 = N+1;
			int case3 = N*2;
			N = func(func(case1, case2), case3);
			sec++;
		}
		System.out.println(sec);
	}

	private static int func(int a, int b) {
		int ans = 0;
		//몫이 다르다면
		if(K/a != K/b) {
			//몫이 자연수면 몫끼리 비교해서 도출
			if(K/a > 0 && K/b > 0)
				ans = (K/a > K/b) ? b : a;
			//몫이 0이면 동생과의 거리가 가까운 값을 선택
			else {
				ans = (Math.abs(K-a) > Math.abs(K-b)) ? b : a;
			}
		}
		//몫이 같다면
		else {
			//나머지(거리)가 더 작은걸 선택
			ans = (K%a > K%b) ? b : a;
		}
		return ans;
	}
}
