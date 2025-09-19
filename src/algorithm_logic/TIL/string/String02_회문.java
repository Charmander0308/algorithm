package algorithm_logic.TIL.string;

public class String02_회문 {
	public static void main(String[] args) {
		String str = "@다시합창합시다";
		
		int N = str.length();
		
		//1. 뒤집기(반복문)
		char[] arr = new char[N];
		for(int i = 0; i < N; i++) {
			arr[i] = str.charAt(N-1-i);
		}
		String str2 = new String(arr);
		System.out.println(str2);
		
		//2. StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append(str).reverse();
		System.out.println(sb);
//		System.out.println(sb.toString());	//둘의 차이는?
		
		//3. swap
		char[] arr2 = str.toCharArray();
		for(int i = 0; i < N/2; i++) {
			//i의 증가에 따라 스왑을 연결한 선의 폭이 점점 줄어든다(점점 가운데로 옴)
			char tmp = arr2[i];
			arr2[i] = arr2[N-1-i];
			arr2[N-1-i] = tmp;
		}
		System.out.println(new String(arr2));
		
		
	}

}
