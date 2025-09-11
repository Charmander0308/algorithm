package sep2025.day21_0911.SWEA.nqueen2806;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int count;
	static int N;
	static int[] col;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/sep2025/day21_0911/SWEA/nqueen2806/sample_input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			count = 0;
			N = sc.nextInt();
			col = new int[N];
			nqueen(0);
			
			System.out.println("#" + test_case + " " + count);
		}
	
	}
	
	static void nqueen(int row) {
		//다왔다! = 하나 찾았다!
		if(row == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			col[row] = i;	//row 행에는 i 열에 둬보자!
			if(promise(row)) nqueen(row + 1);	//문제 없으면 다음 행으로
		}
		
	}
	
	//유망성 검사
	static boolean promise(int row) {
		for(int i=0; i<row; i++) {
			//같은 열에 있으면 안됨!
			if (col[row] == col[i]) {
                return false;
            }
			//대각선에 있어도 안됨!
			if (Math.abs(row - i) == Math.abs(col[row] - col[i])) {
                return false;
            }
		}
		
		return true;
	}
}
