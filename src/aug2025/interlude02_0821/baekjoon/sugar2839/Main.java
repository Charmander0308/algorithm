package aug2025.interlude02_0821.baekjoon.sugar2839;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int remainder = N % 5;	//5로 나눈 나머지
		int bag_5kg = N / 5;	//5로 나눈 몫(5kg 봉지 수)
		int answer = 0;
		
		while(true) {
			//5키로 봉지도 없고, 남은 설탕이 3으로 나누어 떨어지지 않으면 불가능(-1)
			if(bag_5kg == 0 && remainder % 3 != 0) {
				answer = -1;
				break;
			}
			//나머지가 3으로 안나누어떨어지면 5키로씩 추가하고 5키로봉지수 1감소
			if(remainder % 3 != 0) {
				remainder += 5;
				bag_5kg--;
			} else {
				//나누어지면 최소봉지 수 answer에 저장
				answer += (bag_5kg + remainder/3);
				break;
			}
		}
		System.out.println(answer);
	}
}
