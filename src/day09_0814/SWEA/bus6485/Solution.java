package day09_0814.SWEA.bus6485;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day09_0814/SWEA/bus6485/s_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			//0 : 첫번째 버스의 버정시작&끝번호
			int[] min = new int[N];
			int[] max = new int[N];
			for(int i = 0; i < N; i++) {
				min[i] = sc.nextInt();
				max[i] = sc.nextInt();
			}
			//버정번호
			int P = sc.nextInt();
			int[] busStop = new int[P];
			for(int i = 0; i < P; i++) {
				busStop[i] = sc.nextInt();
			}
			//버정 몇번 지나는지 세어보자
			int[] count = new int[P];
			for(int i=0; i < N; i++) {
				for(int j = min[i]-1; j < max[i]; j++) {
					count[j]++;
				}
			}
			//출력
			System.out.print("#" + test_case);
			for(int i=0; i < P; i++) {
				System.out.print(" " + count[i]);
			}
			System.out.println();
		}
		sc.close();
	}

}
