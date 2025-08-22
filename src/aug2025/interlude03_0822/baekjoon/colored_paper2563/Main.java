package aug2025.interlude03_0822.baekjoon.colored_paper2563;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] colored_papers = new int[N][4]; //0:x, 1:y, 2:x+10, 3:y+10
		
		for(int i = 0 ; i < N; i++) {
			colored_papers[i][0] = sc.nextInt();
			colored_papers[i][1] = sc.nextInt();
			colored_papers[i][2] = colored_papers[i][0] + 10;
			colored_papers[i][3] = colored_papers[i][1] + 10;
		}
		int total = (10 * 10) * N;
		
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				//좌표 두개 비교했을때 양 좌표의 x와 y의 차의 절대값이 둘다 10보다 작으면 겹친것.
				//양좌표(하나는 원본, 하나는 +10)의 차로 나올 수 있는 절대값 중 작은 것끼리 곱하면 겹친 영역의 너비니까 그걸 total에서 빼준다.
				if(Math.abs(colored_papers[i][0] - colored_papers[j][0]) < 10 
						&& Math.abs(colored_papers[i][1] - colored_papers[j][1]) < 10){
							total -= Math.min(Math.abs(colored_papers[i][0] - colored_papers[j][2]), Math.abs(colored_papers[i][2] - colored_papers[j][0]))
							* Math.min(Math.abs(colored_papers[i][1] - colored_papers[j][3]), Math.abs(colored_papers[i][3] - colored_papers[j][1]));
						}
				
				System.out.println(i + "," + j + ":" +total);
			}
		}
		
		System.out.println(total);
		
		
	}

}
