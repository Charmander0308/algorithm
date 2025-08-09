package weekend01_0809.baekjoon.remainder3052;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//10개 담자 
		int[] arr = new int[10];
		//입력받은 값의 나머지를 배열에 담자 
		for(int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
			arr[i] %= 42;
		}
		//배열의 값이 다 다르다고 가정 
		int ans = 10;
		//앞에서부터 하나씩 비교해서 중복 있으면 하나 찾았으니 ans 1감소, 계속 비교하면 중복된 값만큼 계속 감소가 발생하니 break로 다음꺼로 넘어감 
		for(int i = 0; i < 10; i++) {
			for(int j = i+1; j < 10; j++) {
				if(arr[i] == arr[j]) {
					ans--;
					break;
				}
			}
		}
		//제출 
		System.out.println(ans);
		sc.close();
	}
}