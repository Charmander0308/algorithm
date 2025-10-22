package oct2025.day1022.BOJ.hideAndSeek1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//얘가 통과한 코드임
public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] times = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		times[N] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == K) {
				System.out.println(times[now] - 1);
				break;
			}
			
			int[] cases = {now-1, now+1, now*2};
			for(int c : cases) {
				if(c >= 0 && c <= 100000 && times[c] == 0) {
					q.add(c);
					times[c] = times[now] + 1;
				}
			}
		}
	}
}
