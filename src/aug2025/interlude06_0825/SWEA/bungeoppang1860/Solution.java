package aug2025.interlude06_0825.SWEA.bungeoppang1860;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/aug2025/interlude06_0825/SWEA/bungeoppang1860/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] customer = new int[N];
			for(int i=0; i < N; i++) {
				customer[i] = sc.nextInt();
			}
			Arrays.sort(customer);
			boolean isOk = true;
			
			for(int i=0; i<N; i++) {
				if(customer[i]/M*K-i-1 < 0) {
					isOk = false;
					break;
				}
			}
			System.out.print("#" + test_case + " ");
			if(isOk == false) System.out.println("Impossible");
			else System.out.println("Possible");
			
		}
		
	}

}
