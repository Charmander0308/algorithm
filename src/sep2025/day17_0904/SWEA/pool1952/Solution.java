package sep2025.day17_0904.SWEA.pool1952;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] price;	//이용권 가격
	static int[] month;	//12개월 이용계획
	static int ans;
	
	public static void main(String[] args) throws IOException {
//		File file = new File("src/sep2025/day17_0904/SWEA/pool1952/sample_input.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			//이용권 가격들 담기
			StringTokenizer st = new StringTokenizer(br.readLine());
			price = new int[5];
			for(int i=1; i<=4; i++) price[i] = Integer.parseInt(st.nextToken());
			
			//12개월 이용계획 담기
			st = new StringTokenizer(br.readLine());
			month = new int[13];
			for(int i=1; i<=12; i++) month[i] = Integer.parseInt(st.nextToken());
			
			System.out.println(Arrays.toString(price));
			System.out.println(Arrays.toString(month));
			
			ans = price[4];
			dfs(1, 0);
			System.out.println("#" + test_case + " " + ans);
			
		}
		
	}
	
	static void dfs(int mon, int cost) {
		if(mon > 12) {
			ans = Math.min(ans, cost);
			return;
		}
		if(cost >= ans) {
			return;
		}
		//1. 일일권을 산 경우
		dfs(mon + 1, cost + (price[1] * month[mon]));
		//2. 1달권
		dfs(mon + 1, cost + price[2]);
		//3. 3달권
		if(mon <= 10)
			dfs(mon + 3, cost + price[3]);
		
	}

}
