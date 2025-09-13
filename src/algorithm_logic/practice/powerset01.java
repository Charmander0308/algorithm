package algorithm_logic.practice;

public class powerset01 {
	static String[] material = {"단무지", "햄", "오이"};
	static boolean[] sel;
	static int N;
	
	public static void main(String[] args) {
		N = material.length;
		sel = new boolean[N];
		powerset(0);
		
		
	}

	private static void powerset(int idx) {
		if(idx == N) {
			for(int i=0; i < N; i++) {
				if(sel[i]) System.out.print(material[i]);
			}
			System.out.println();
			return;
		}
		sel[idx] = true;
		powerset(idx+1);
		
		sel[idx] = false;
		powerset(idx+1);
		
		
	} 
}
