package aug2025.interlude08_0827.baekjoon.colored_paper10163;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] area = new int[1001][1001];	//평면
		int[] count = new int[N];	//면적 세는용
		
		for(int k=1; k<=N; k++) {
			int r = sc.nextInt();	//가장 작은 r값
			int c = sc.nextInt();	//가장 작은 c값
			int w = sc.nextInt();	//너비
			int h = sc.nextInt();	//높이
			
			//평면에 해당 색종이가 놓인 부분이면 k로 값을 변경, 나중에 놓인게 더 위니까 덮어쓰게함
			for(int i=0; i<1001; i++) {
				for(int j=0; j<1001; j++) {
					if(i>=r && i<r+w && j>=c && j<c+h) {
						area[i][j] = k;
					}
				}
			}
		}
		//평면 순회하며 0이 아닐경우 해당 값에 대한 카운트배열 1증가
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				if(area[i][j]!=0) count[area[i][j]-1]++;
			}
		}
		//순서대로 출력
		for(int i=0; i<N; i++) {
			System.out.println(count[i]);
		}
	}
}
