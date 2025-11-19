package nov2025.day1119.BOJ.bulb2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] start;
	static int[] end;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		start = new int[N];
		String startNum = br.readLine();
		for(int i=0; i<N; i++) {
			start[i] = startNum.charAt(i)-'0';
		}
		
		String endNum = br.readLine();
		end = new int[N];
		for(int i=0; i<N; i++) {
			end[i] = endNum.charAt(i)-'0';
		}
		
		funtion(idx);
		
		
		
	}

	private static void funtion(int idx) {
		
	}
}
