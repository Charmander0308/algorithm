package weekend01_0809.baekjoon.maxmin10818;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//정수의 개수 
		int N = sc.nextInt();
		//조건의 최대와 최소값을 활용하여 max, min 변수 선
		int max = -1000000;
		int min = 1000000;
		//정수 개수만큼 반복하며 입력받고, 각 값을 최대 최소 비교하여 연산 
		for(int i = 1; i <= N; i++) {
			int input = sc.nextInt();
			if(input > max) max=input;
			if(input < min) min=input;
		}
		System.out.println(min + " " + max);
		
	}

}
