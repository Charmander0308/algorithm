package sep2025.day14_0901.SWEA.involution1217;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day14_0901/SWEA/involution1217/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int testNum = sc.nextInt();
			
			int base = sc.nextInt();
			int exponent = sc.nextInt();
			
			System.out.println(involution(base, exponent));
			
		}
		
	}

	static int involution(int base, int exponent) {
		//종료
		if(exponent == 0) return 1;
		//재귀
		if(exponent % 2 != 0) {
			return involution(base, exponent/2) * involution(base, exponent/2) * base;
		} else {
			return involution(base, exponent/2) * involution(base, exponent/2);
		}
	}

}
