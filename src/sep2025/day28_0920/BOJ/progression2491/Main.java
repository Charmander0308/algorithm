package sep2025.day28_0920.BOJ.progression2491;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//담을 배열 만들기
		int[] arr = new int[N];
		//초기세팅
		arr[0] = sc.nextInt();	
		int upCount = 1;
		int downCount = 1;
		int ans = 1;
		
		for(int i=1; i<N; i++) {
			arr[i] = sc.nextInt();
			//올라가는 순열 체크
			if(arr[i-1] <= arr[i]) upCount++;
			else upCount = 1;
			//내려가는 순열 체크
			if(arr[i-1] >= arr[i]) downCount++;
			else downCount = 1;
			
			ans = Math.max(ans, upCount);
			ans = Math.max(ans, downCount);
		}
		System.out.println(ans);
		
	}
}
