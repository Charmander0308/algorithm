package aug2025.day07_0812.baekjoon.switch1244;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//스위치 개수 
		int switchCount = sc.nextInt();
		//스위치 상태 
		int[] switchStatus = new int[switchCount];
		for(int i=0; i < switchCount; i++) {
			switchStatus[i] = sc.nextInt();
		}
		//학생 수 
		int studentCount = sc.nextInt();
		
		//학생 성별 + 받은 수 입력받기 
		for(int i = 0; i < studentCount; i++) {
			int gender = sc.nextInt();
			int number = sc.nextInt();
			
			//남자면 해당 수의 배수 스위치 상태 변경 
			if(gender == 1) {
				for(int j = 0; j < switchCount; j++) {
					if((j+1)%number == 0) {
						switchStatus[j] = Math.abs(switchStatus[j]-1);
					}
				}
			}
			//여자면 스위치 대칭 확인해서 상태 변경 
			else if(gender == 2) {
				for(int j = 0; j < (switchCount+1)/2; j++) {
					//배열 밖으로 벗어나면 종료 
					if(number+j > switchCount || number-j < 1) {
						break;
					}
					//대칭이 아니면 종료 
					if(switchStatus[number+j-1]!=switchStatus[number-j-1]) {
						break;
					} else {
						//대칭이면 사이좋게 상태 변경 
						switchStatus[number+j-1] = switchStatus[number-j-1] = Math.abs(switchStatus[number+j-1]-1);
					}
				}
			}
		}
		//출력 
		for(int i = 0; i < switchCount; i++) {
			System.out.print(switchStatus[i]);
			if(i < switchCount-1) System.out.print(" ");
			if((i+1)%20 == 0) {
				System.out.println();
			}
		}
		
	sc.close();
		
	}
}
