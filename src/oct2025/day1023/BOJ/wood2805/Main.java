package oct2025.day1023.BOJ.wood2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> woods = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			woods.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(woods, Collections.reverseOrder());
		
		int ans = 0;
		int cutHeight = woods.get(0);
		while(true) {
			cutHeight--;
			int getWoods = 0;
			for(int i=0; i<N; i++) {
				if(woods.get(i) > cutHeight) {
					getWoods += (woods.get(i) - cutHeight);
				}
			}
			if(getWoods >= M) {
				ans = cutHeight;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
