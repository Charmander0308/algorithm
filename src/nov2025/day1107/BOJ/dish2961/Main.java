package nov2025.day1107.BOJ.dish2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Material{
		int sour;
		int bitter;

		public Material(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}
	
	static int N;
	static boolean[] isChecked;
	static Material[] mArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mArr = new Material[N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			mArr[i] = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		isChecked = new boolean[N];
		
		
	}
	
	private void function(int cnt, int sour, int bitter) {
		//종료
		
		//로직
		
		
		
	}
	
}
