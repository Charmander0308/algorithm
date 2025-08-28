package aug2025.day12_0828.SWEA.hamburger5215;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/aug2025/day12_0828/SWEA/hamburger5215/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[][] material = new int[N][2];
			for(int i=0; i<N; i++) {
				material[i][0] = sc.nextInt();	//점수
				material[i][1] = sc.nextInt();	//칼로리
			}
			
			int maxScore = 0;
			for(int i=0; i<(1<<N); i++) {
				int score =0;
				int kcal =0;
				for(int j=0; j<N; j++) {
					if((i&(1<<j)) != 0) {
						score += material[j][0];
						kcal += material[j][1];
					}
				}
				if(kcal <= L) {
					if(score > maxScore) maxScore = score;
				}
			}
			System.out.println("#" + test_case + " " + maxScore);
			
		}
		
	}

}
