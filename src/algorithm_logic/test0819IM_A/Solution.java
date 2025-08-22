package algorithm_logic.test0819IM_A;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] rooms = new int[N];
			//방 받기
			for(int i=0; i< N; i++) {
				rooms[i] = sc.nextInt();
			}
			//왔던곳인가요? 0:아니오 1:예
			int[] roomCheck = new int[N];
			roomCheck[0] = 1;	//처음방은 왔던곳으로 가정(오른쪽으로만 가니까)
			
			int now = 0;
			int count = 0;
			//들락날락
			while(now != N-1) {
				if(roomCheck[now] == 1) {
					now++;
				} else if(roomCheck[now] == 0) {
					roomCheck[now] = 1;
					now = rooms[now]-1;
				}
				count++;
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}
