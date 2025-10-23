package oct2025.day1023.BOJ.wood2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//얘가 통과코드임
public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//나무의 수
		int N = Integer.parseInt(st.nextToken());
		//가져가고싶은 나무의 길이
		int M = Integer.parseInt(st.nextToken());
		
		//나무 높이 배열
		List<Integer> woods = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			woods.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(woods, Collections.reverseOrder());
//		System.out.println(woods);
		
		int answer = 0;
		int start = 0;
		int end = woods.get(0);
		int cutHeight;
		
		while(start <= end) {
			//자르는 기준높이
			cutHeight = (end - start)/2 + start;
			//총 잘린 길이
			long total = 0;
			//하나의 나무에 대한 잘린 길이
			int getWood;
			//자른다면?
			for(int n : woods) {
				getWood = n - cutHeight;
				//자를게 있다면 자른길이를 total에 추가
				if(getWood > 0) {
					total += getWood;
				}
			}
			//자른길이가 가져가고싶은 길이보다 같거나 많으면 좀 더 위에서 잘라보자(정답 후보)
			if(total >= M) {
				start = cutHeight + 1;
				//정답에 일단 저장해두기
				answer = cutHeight;
			}
			//부족하면 더 아래에서 잘라보자
			else if(total < M) {
				end = cutHeight - 1;
			}
		}
		System.out.println(answer);
	}
}
