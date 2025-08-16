package aug2025.weekend03_0816.baekjoon.oriental_melon2477;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//제곱미터당 수확량 
		int melon = sc.nextInt();
		//방향 담는 리스트 
		List<Integer> direction = new ArrayList<>();
		//길이 담는 리스트 
		List<Integer> length = new ArrayList<>();
		//최대 동서,남북  
		int maxWidth = 0, maxHeight = 0;
		//최대의 인덱스들 
		int maxWidthIdx = 0, maxHeightIdx = 0;
		
		//담기 
		for(int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int len = sc.nextInt();
			
			direction.add(dir);
			length.add(len);
			//받은 변의 방향이 동, 서 일 경우 
			if(dir == 1 || dir == 2) {
				//해당 변의 길이가 최대길이인지 체크 
				if(len > maxWidth) {
					maxWidth = len;
					maxWidthIdx = i;
				}
			} 
			//받은 변의 방향이 남, 북 일 경우 
			else if(dir == 3 || dir == 4) {
				if(len > maxHeight) {
					maxHeight = len;
					maxHeightIdx = i;
				}
			}
		}
		//밭이 아닌 부분의 가로 세로 
		int minWidth = 0, minHeight = 0;
		int minWidthIdx = 0, minHeightIdx = 0;
		
		//밭이 아닌 부분의 세로는 밭의 가장 긴 가로에서 3만큼 추가한 인덱스 
		minHeightIdx = (maxWidthIdx + 3) % 6;
		//밭이 아닌 부분의 가로는 밭의 가장 긴 세로에서 3만큼 추가한 인덱스  
		minWidthIdx = (maxHeightIdx + 3) % 6;
		
		//밭이 아닌부분 가로 세로 넣기 
		minWidth = length.get(minWidthIdx);
		minHeight = length.get(minHeightIdx);
		
		// (큰 직사각형 - 밭이 아닌 부분) * 제곱미터당 수확량  
		int answer = ((maxHeight * maxWidth) - (minHeight * minWidth)) * melon;
		System.out.println(answer); 
		
	}

}
