package aug2025.day01_0804.SWEA.view1206;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		
//		[제약 사항]
//
//				가로 길이는 항상 1000이하로 주어진다.
//
//				맨 왼쪽 두 칸과 맨 오른쪽 두 칸에는 건물이 지어지지 않는다. (예시에서 빨간색 땅 부분)
//
//				각 빌딩의 높이는 최대 255이다.
//				 
//				[입력]
//
//				총 10개의 테스트케이스가 주어진다.
//
//				각 테스트케이스의 첫 번째 줄에는 건물의 개수 N이 주어진다. (4 ≤ N ≤ 1000)
//
//				그 다음 줄에는 N개의 건물의 높이가 주어진다. (0 ≤ 각 건물의 높이 ≤ 255)
//
//				맨 왼쪽 두 칸과 맨 오른쪽 두 칸에 있는 건물은 항상 높이가 0이다. (예시에서 빨간색 땅 부분)
//				 
//				[출력]
//
//				#부호와 함께 테스트케이스의 번호를 출력하고, 공백 문자 후 조망권이 확보된 세대의 수를 출력한다.
		
		File file = new File("src/day01_0804/SWEA/view1206/sample_input.txt");
		
		Scanner sc = new Scanner(file);
		int T = 10;

		
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			
			//건물의 개수 담기
			int N = sc.nextInt();
			//건물의 높이 담기
			int[] numArr = new int[N];
			for(int i = 0; i < N; i++) {
				numArr[i] = sc.nextInt();
			}
			if(N > 5) {
				//조건 만족 시, 반경 2 이내의 건물 높이의 최대값 담기
				//양 옆 두칸은 0이 고정이므로 제외, 나머지 범위 반복문 돌리기
				for(int i = 2; i <= N-1-2; i++) {
					int max = 0;
					//포인터i 기준 양 옆 두칸 조회
					for(int j = i-2; j <= i+2; j++) {
						//같은 건물은 배제
						if(j==i) {
							continue;
						}
						//조망 확보 안되면 다음 건물로
						if(numArr[j] >= numArr[i]) {
							max = 0;
							break;
						}
						//가장 높은 건물이라면 max에 넣기
						if(numArr[j] > max) {
							max = numArr[j];
						}
					}
					//max에 값이 있다면(=위의 for문을 통과했다면 조망권이 확보된 건물) 조망권이 확보된 세대의 수를 ans에 추가  
					if(max != 0) {
						ans += numArr[i] - max;
					}
				}
			} else {
				ans = numArr[N/2];
			}
			
			//정답을 출력할 때 #tc ans
			System.out.println("#" + tc + " " + ans);
			
		}
	}
}
