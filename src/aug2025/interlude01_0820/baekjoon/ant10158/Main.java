package aug2025.interlude01_0820.baekjoon.ant10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());	//격자 가로 
		int h = Integer.parseInt(st.nextToken());	//격자 세로
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());	//시작점 가로
		int q = Integer.parseInt(st.nextToken());	//시작점 세로
		
		int t = Integer.parseInt(br.readLine());	//움직이는 시간
		
		//좌표 별 잔여 t 계산
		int remainderTofP = t % (w * 2);
		int remainderTofQ = t % (h * 2);
		
		int answer_p = 0, answer_q = 0;
		//남은 t에 대한 p, q의 최종 위치 구하기
		if(((p + remainderTofP)/w)%2 == 0)
			answer_p = (p + remainderTofP) % w;
		else
			answer_p = w - (p + remainderTofP) % w;
		if(((q + remainderTofQ)/h)%2 == 0)
			answer_q = (q + remainderTofQ) % h;
		else
			answer_q = h - (q + remainderTofQ) % h;
		
		//어디있니
		System.out.println(answer_p + " " + answer_q);
		
	}

}
