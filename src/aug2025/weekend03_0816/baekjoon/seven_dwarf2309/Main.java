package aug2025.weekend03_0816.baekjoon.seven_dwarf2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dwarfs = new int[9];
		int total = 0;
		//난쟁이 정보 입력 
		for(int i = 0; i < 9; i++) {
			dwarfs[i] = sc.nextInt();
			total+= dwarfs[i];
		}
//		System.out.println(total);
		//난쟁이 키의 합 - 100을 저장. 범인 난쟁이 둘의 키를 합치면 저 값이 됨. 
		int gap = total - 100;
		//for문 탈출용 
		boolean isOk = true;
		//수색시작 
		for(int i = 0; i < dwarfs.length; i++) {
			for(int j = i+1; j < dwarfs.length; j++) {
				//범인 발견하면 수색 종료 
				if(dwarfs[i]+dwarfs[j] == gap) {
					dwarfs[i] = 0;
					dwarfs[j] = 0;
					isOk = false;
					break;
				}
			}
			if(isOk == false) break;
		}
		//오름차순 정렬 
		Arrays.sort(dwarfs);
		//제거된 난쟁이 제외하고 키 출력 
		for(int i = 0; i < dwarfs.length; i++) {
			if(dwarfs[i] != 0) {
				System.out.println(dwarfs[i]);
			}
		}
	}
}