package nov2025.day1119.BOJ.bulb2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] end;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] case1 = new int[N];
		int[] case2 = new int[N];
		String startNum = br.readLine();
		for(int i=0; i<N; i++) {
			int num = startNum.charAt(i)-'0';
			case1[i] = num;
			case2[i] = num;
		}
		
		String endNum = br.readLine();
		end = new int[N];
		for(int i=0; i<N; i++) {
			end[i] = endNum.charAt(i)-'0';
		}
		
		int ans = -1;
		
		//0번 인덱스를 누르지 않을경우
		int cnt1 = 0;
		for(int i=1; i<N; i++) {
			if(case1[i-1] != end[i-1]) {
				switching(case1, i);
				cnt1++;
			}
		}
		if(scanning(case1)) {
			ans = cnt1;
		}
		
		//0번 인덱스를 누른경우
		switching(case2, 0);
		int cnt2 = 1;
		for(int i=1; i<N; i++) {
			if(case2[i-1] != end[i-1]) {
				switching(case2, i);
				cnt2++;
			}
		}
		if(scanning(case2)) {
			if(ans == -1) ans = cnt2;
			else ans = Math.min(ans, cnt2);
		}
		
		System.out.println(ans);
		
		
	}

	private static boolean scanning(int[] arr) {
		for(int i=0; i<N; i++) {
			if(arr[i] != end[i]) {
				return false;
			}
		}
		return true;
	}

	private static void switching(int[] arr, int idx) {
//		System.out.println("idx: " + idx);
		if(idx-1 >= 0) arr[idx-1] = Math.abs(arr[idx-1]-1);
		arr[idx] = Math.abs(arr[idx]-1);
		if(idx+1 < N) arr[idx+1] = Math.abs(arr[idx+1]-1);
	}
}
