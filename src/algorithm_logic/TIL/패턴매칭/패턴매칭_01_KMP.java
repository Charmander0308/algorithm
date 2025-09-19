package algorithm_logic.TIL.패턴매칭;

public class 패턴매칭_01_KMP {
	public static void main(String[] args) {
		String text = "";
		String pattern = "";
	}
	public static void KMP(String t, String p) {
		int[] pi = getPi(p);
		
		int j = 0;	//패턴의 인덱스
		for(int i=0; i<t.length(); i++) {
			//1. 다를때
			while(j>0 && t.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			
			//2. 같을때
			if(t.charAt(i) == p.charAt(j)) {
				if(j == p.length()-1) {
					//패턴을 찾았다! (i-p.length()+1)
					j = pi[j];
				}
				else {
					j++;
				}
			}
			
		}//본문을 순회하면서 검사를 진행하겠다.
		
		
	}
	
	//pi[] : 패턴 pt를 i인덱스까지 잘라서 접두사와 접미사가 일치하는 최대길이를 저장
	public static int[] getPi(String pt) {
		int[] pi = new int[pt.length()];
		
		int j=0;
		for(int i=1; i<pt.length(); i++) {
			while(j>0 && pt.charAt(i) != pt.charAt(j))
				j = pi[j-1];
			
			//같다면 기록한다.
			if(pt.charAt(i) == pt.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	
}
