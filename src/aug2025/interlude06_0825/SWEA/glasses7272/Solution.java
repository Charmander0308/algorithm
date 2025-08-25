package aug2025.interlude06_0825.SWEA.glasses7272;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/aug2025/interlude06_0825/SWEA/glasses7272/s_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String word1 = sc.next();
			String word2 = sc.next();
			
			boolean isOk = true;
			
			if(word1.length() != word2.length()) {
				isOk = false;
			} else {
				for(int i=0; i < word1.length(); i++) {
					char c1 = word1.charAt(i);
					char c2 = word2.charAt(i);
					int word1_kind = 0;
					int word2_kind = 0;
					if(c1 == 'B') {
						word1_kind = 2;
					} else if(c1 == 'A'||c1 == 'D'||c1 == 'O'||c1 == 'P'||c1 == 'Q'||c1 == 'R') {
						word1_kind = 1;
					} 
					if(c2 == 'B') {
						word2_kind = 2;
					} else if(c2 == 'A'||c2 == 'D'||c2 == 'O'||c2 == 'P'||c2 == 'Q'||c2 == 'R') {
						word2_kind = 1;
					} 
					if(word1_kind != word2_kind) {
						isOk = false;
						break;
					}
				}
			}
			System.out.print("#" + test_case + " ");
			if(isOk == false) {
				System.out.println("DIFF");
			} else {
				System.out.println("SAME");
			}
			
		}
		
	}

}
