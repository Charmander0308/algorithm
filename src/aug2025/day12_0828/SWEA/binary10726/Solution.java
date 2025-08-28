package aug2025.day12_0828.SWEA.binary10726;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/aug2025/day12_0828/SWEA/binary10726/input.txt");
		Scanner sc = new Scanner(file);
		int T =  sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String state = "ON";
			for(int i=0; i<N; i++) {
				if((M & (1<<i))==0) {
					state = "OFF";
					break;
				}
			}
			System.out.println("#" + test_case + " " + state);
		}
	}
}
