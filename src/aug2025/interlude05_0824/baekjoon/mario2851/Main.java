package aug2025.interlude05_0824.baekjoon.mario2851;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mushroom = new int[10];
		int score = 0;
		
		for(int i=0; i<10; i++) {
			mushroom[i] = sc.nextInt();
		}
		
		int num = 0;
		for(int j=0; j<10; j++) {
			int nextNum = num + mushroom[j];
			if(Math.abs(nextNum-100) < Math.abs(num-100)) {
				num = nextNum;
			} else if(Math.abs(nextNum-100) == Math.abs(num-100)) {
				if(nextNum > num) 
					num = nextNum;
			} else {
				break;
			}
		}
		if(Math.abs(num-100) < Math.abs(score-100)) {
			score = num;
		} else if(Math.abs(num-100) == Math.abs(score-100)) {
			if(num > score) score = num;
		}
	
		System.out.println(score);
		
	}
}
