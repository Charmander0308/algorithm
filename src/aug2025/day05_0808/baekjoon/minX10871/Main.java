package aug2025.day05_0808.baekjoon.minX10871;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num < X) list.add(num);
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if(i < list.size()-1) {
				System.out.print(" ");
			}
		}
	}
}
