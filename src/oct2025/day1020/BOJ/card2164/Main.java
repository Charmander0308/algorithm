package oct2025.day1020.BOJ.card2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> ad = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			ad.addLast(i);
		}
		
		while(ad.size() > 1) {
			ad.removeFirst();
			int num = ad.removeFirst();
			ad.addLast(num);
		}
		System.out.println(ad.getFirst());
		
	}
}
