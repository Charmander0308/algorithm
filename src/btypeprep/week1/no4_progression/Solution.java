package btypeprep.week1.no4_progression;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1 ; test_case <= T; test_case++) {
			int N = sc.nextInt();	//수열의 길이
			int M = sc.nextInt();	//추가 횟수
			int L = sc.nextInt();	//출력할 인덱스 번호
			
			List<Integer> list = new LinkedList<>();
			for(int i=0; i<N; i++) {
				list.add(sc.nextInt());
			}
			
			/*
			 * I 2 7 : 2번 앞에 7 추가, 한 칸씩 뒤로 이동
			 * D 4 : 4번 지우고 한 칸씩 앞으로 땡기기
			 * C 3 8 : 3번 자리를 8로 바꾼다
			 * L이 없다면 -1 출력
			 * 
			 * */
			
			for(int i=0; i<M; i++) {
				String input = sc.next();
				
				switch (input) {
				case "I":
					int iidx = sc.nextInt();
					int inum = sc.nextInt();
					list.add(iidx, inum);
					break;
				case "D":
					int dnum = sc.nextInt();
					list.remove(dnum);
					break;
				case "C":
					int cidx = sc.nextInt();
					int cnum = sc.nextInt();
					list.set(cidx, cnum);
					break;
				}
				
			}
			System.out.print("#" + test_case + " ");
			if(list.size() <= L) {
				System.out.println(-1);
			} 
			else {
				System.out.println(list.get(L));
			}
		}
	}

}
