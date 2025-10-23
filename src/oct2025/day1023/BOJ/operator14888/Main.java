package oct2025.day1023.BOJ.operator14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] numList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//수의 개수
		N = Integer.parseInt(br.readLine());
		//수열
		StringTokenizer st = new StringTokenizer(br.readLine());
		numList = new int[N];
		for(int i=0; i<N; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}
		//연산자 배열
		st = new StringTokenizer(br.readLine());
		int[] operatorCnt = new int[4];
		for(int i=0; i<4; i++) {
			operatorCnt[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(N);
//		System.out.println(numList);
//		System.out.println(Arrays.toString(operator));
		
		func(numList[0], 1, operatorCnt);
		System.out.println(max);
		System.out.println(min);
		
	}

	private static void func(int num, int idx, int[] operator) {
		if(idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				switch (i) {
				case 0:
					func(num + numList[idx], idx + 1, operator);
					break;
				case 1:
					func(num - numList[idx], idx + 1, operator);
					break;
				case 2:
					func(num * numList[idx], idx + 1, operator);
					break;
				case 3:
					func(num / numList[idx], idx + 1, operator);
					break;
				}
				operator[i]++;
			}
		}
		
	}
	
}
