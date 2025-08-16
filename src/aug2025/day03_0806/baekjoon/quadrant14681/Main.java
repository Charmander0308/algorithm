package aug2025.day03_0806.baekjoon.quadrant14681;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = Integer.parseInt(sc.nextLine());
		int c = Integer.parseInt(sc.nextLine());
		int ans = 0;
		
		if(r > 0 && c > 0) {
			ans = 1;
		} else if(r < 0 && c > 0) {
			ans = 2;
		} else if(r < 0 && c < 0) {
			ans = 3;
		} else if(r > 0 && c < 0) {
			ans = 4;
		}
		System.out.println(ans);
	}
}
