package aug2025.day05_0808.SWEA.involution1217;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day05_0808/SWEA/involution1217/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			int base = sc.nextInt();
			int exponent = sc.nextInt();
			
			System.out.println("#" + tc + " " + involution(base, exponent));
		}
	}
	
	//재귀호출 연산용 
	static int num = 1;
	
	private static int involution(int base, int exponent) {
		//num에 밑을 1회 곱해줌
		num *= base;
		//지수가 1보다 크면 1 차감 
		while(exponent > 1) {
			exponent--;
			//재귀호출로 지수가 1될때까지 반복
			return involution(base, exponent);
		}
		//연산이 끝나면 num 초기화를 진행 후 return
		int ans = num;
		num = 1;
		return ans;
	}

}
