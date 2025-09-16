package sep2025.day24_0916.SWEA.question7087;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day24_0916/SWEA/question7087/sample_input.txt");
		Scanner sc= new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int[] words = new int[26];
			for(int i=0; i<N; i++) {
				String s = sc.next();
				words[s.charAt(0)-'A']++;
			}
			int ans = 0;
			for(int i=0; i<words.length; i++) {
				if(words[i] == 0) break;
				ans++;
			}
			
			System.out.println("#" + test_case + " " + ans);
			
		}
	}
}
