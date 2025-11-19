package btypeprep.week1.no3_ciphertext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/btypeprep/week1/no3_ciphertext/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			List<Integer> list = new LinkedList<>();
			//암호문 수
			int N = sc.nextInt();
			for(int i=0; i<N; i++) {
				list.add(sc.nextInt());
			}
			//명령어 수
			int M = sc.nextInt();
			
			while(M > 0) {
				String s = sc.next();
				switch (s) {
				case "I":
					int idx1 = sc.nextInt();
					int cnt1 = sc.nextInt();
					for(int i=0; i<cnt1; i++) {
						list.add(idx1 + i, sc.nextInt());
					}
					break;
				case "D":
					int idx2 = sc.nextInt();
					int cnt2 = sc.nextInt();
					for(int i=0; i<cnt2; i++) {
						list.remove(idx2);
					}
					break;
				case "A":
					int cnt3 = sc.nextInt();
					for(int i=0; i<cnt3; i++) {
						list.add(sc.nextInt());
					}
					break;
				}
				M--;
			}
			
			System.out.print("#" + test_case);
			for(int i=0; i<10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
		
	}

}
