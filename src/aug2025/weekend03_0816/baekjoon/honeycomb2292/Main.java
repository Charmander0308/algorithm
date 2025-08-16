package aug2025.weekend03_0816.baekjoon.honeycomb2292;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//시작을 포함하여 계산 
		int num = 1;
		int count = 1;
		//곱해지는 값을 1씩 늘려가며 뺄셈 반복. 뺄 값보다 남은 값이 작아질 때까지. 
		while(N > num) {
			num += 6 * count++;
		}
		//출력 
		System.out.println(count);
	}
}
