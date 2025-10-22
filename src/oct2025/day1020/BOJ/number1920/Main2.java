package oct2025.day1020.BOJ.number1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

//얘가 통과코드임
public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N
		int N = Integer.parseInt(br.readLine());
		//N배열
		HashSet<Integer> nArr = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nArr.add(Integer.parseInt(st.nextToken()));
		}
		//M
		int M = Integer.parseInt(br.readLine());
		//M만큼 요소 포함여부 체크
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int checkNum = Integer.parseInt(st.nextToken());
			
			if(nArr.contains(checkNum)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			
		}
	}
}
