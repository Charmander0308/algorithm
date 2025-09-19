package algorithm_logic.TEST.test0901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Algo2_서울_13반_한예성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T; test_case++) {
			List<Integer> answer = new ArrayList<>();
			//덱은 총 6개의 카드
			int[] cards = new int[6];
			//우선 5개를 뽑음
			for(int i=0; i<5; i++) {
				cards[i] = sc.nextInt();
			}
			//정렬(맨앞이 무조건 0)
			Arrays.sort(cards);
//			System.out.println("cards"+Arrays.toString(cards));
			//새 카드가 1부터 9인 경우 체크
			for(int i=1; i<=9; i++) {
				//세트 세는용(스트레이트나 트리플)
				int num=0;
				//깊은복사(원본 유지위해)
				int[] copy = new int[6];
				//트리플 여부 확인용
				int[] count = new int[10];
				//깊은복사
				for(int j=0; j<6; j++) {
					copy[j] = cards[j];
				}
//				System.out.println("정렬 전" + Arrays.toString(copy));
				//맨 앞에 새 카드 넣기
				copy[0] = i;
				//다시 정렬
				Arrays.sort(copy);
//				System.out.println("정렬 후" + Arrays.toString(copy));
				//덱을 체크해보자
				for(int j=0; j<6; j++) {
					//해당 카드 갯수 1추가
					count[copy[j]]++;
//					System.out.println(Arrays.toString(count));
					//세번째 카드부터 검사
					if(j>=2 && j<6) {
						//앞의 두개가 순차번호이며, 이전에 유효로 판정된 적 없는 카드인 경우 스트레이트
						if(copy[j]-1 == copy[j-1] && copy[j]-2 == copy[j-2] && count[copy[j-1]]!=0 && count[copy[j-2]]!=0) {
							num++;
							//트리플 체크 시 중복 방지
							count[copy[j-2]]--;
							count[copy[j-1]]--;
							count[copy[j]]--;
						}
					}
				}
				//같은 카드가 3개면 트리플
				for(int j=0; j<10; j++) {
					if(count[j] == 3) num++;
				}
				//유효인 경우가 2가지면 정답에 추가
				if(num == 2) {
					answer.add(i);
				}
//				System.out.println("i=" + i + ":" + num);
			}
			//정답 출력, 없으면 0출력
			System.out.print("#"+test_case);
			if(!answer.isEmpty()) {
				for(int i=0; i<answer.size(); i++) {
					System.out.print(" "+answer.get(i));
				}
			} else {
				System.out.print(" " + 0);
			}
			System.out.println();
			
 		}
		
	}
}
