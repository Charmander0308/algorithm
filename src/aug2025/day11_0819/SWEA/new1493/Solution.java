package aug2025.day11_0819.SWEA.new1493;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
			
		File file = new File("src/aug2025/day11_0819/SWEA/new1493/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int px = getXY(p)[0];
			int py = getXY(p)[1];
			int qx = getXY(q)[0];
			int qy = getXY(q)[1];
			
			int answer_x = px + qx;
			int answer_y = py + qy;
			
			int answer = getValue(answer_x, answer_y);
			System.out.println("#" + test_case + " " + answer);
		}
	}
	
	//값에 대한 좌표를 리턴하는 메서드
	public static int[] getXY(int value) {
		int[] xy = new int[2];
		//(1,1)을 시작점으로 둘거라 초기화를 해당 좌표 기준으로 진행
		int sum = 2; //좌표끼리 더한 값(대각선이 진행될수록 1씩 늘어남)
		int num = 1; //이번 대각선에서 증가된 수의 양(처음엔 1, 두번째엔 2, 세번째엔 3, ...이 이전보다 증가) 
		while(value > num) {
			value -= num;
			num++;
			sum++;
		}
		xy[0] = value;
		xy[1] = sum - value;
		
		return xy;
	}
	
	//좌표에 대한 값을 리턴하는 메서드
	public static int getValue(int x, int y) {
		int index = x + y - 1;
		int sum = 0;
		for(int i = 1; i <= index; i++) {
			sum += i;
		}
		int answer = sum - (index - x);
		return answer;
	}
}
