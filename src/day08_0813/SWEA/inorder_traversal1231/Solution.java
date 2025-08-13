package day08_0813.SWEA.inorder_traversal1231;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Solution {
	//다른 함수에서도 활용해야하므로 static으로 만들기
	static int[][] node;
	static String[] value;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day08_0813/SWEA/inorder_traversal1231/input.txt");
		Scanner sc = new Scanner(file);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int count = sc.nextInt();
			sc.nextLine();
			
			node = new int[count+1][3]; //0:왼자 1:오자 2:부모  
			value = new String[count+1];
 			
			//count만큼 줄 읽기
			for(int i = 1; i < count+1; i++) {
				String line = sc.nextLine();
				//토큰마다 읽어오기 
				StringTokenizer st = new StringTokenizer(line);
				//줄의 첫번째는 부모 번호 
				int parentNum = Integer.parseInt(st.nextToken());
				//두번째는 알파벳 
				value[i] = st.nextToken();
				
				//다음 토큰이 있으면 자식에 추가 
				while(st.hasMoreTokens()) {
					int childNum = Integer.parseInt(st.nextToken());
					//왼쪽->오른쪽 순으로 채우기 
					if(node[i][0] == 0) {
						node[i][0] = childNum;
					} else if(node[i][1] == 0){
						node[i][1] = childNum;
					} 
					node[childNum][2] = parentNum;
				}
			}
			//잘 나오는지 확인 
//			for(int i = 1; i < count+1; i++) {
//				System.out.println(i + "번: " +Arrays.toString(node[i]) + ", 문자: "+value[i]);
//			}
			//출력 
			System.out.print("#" + test_case + " ");
			inorder(1);
			System.out.println();
		}
		sc.close();
		
	}
	//중위순회 메서드 
	public static void inorder(int curr) {
		if(curr != 0) {
			inorder(node[curr][0]);
			System.out.print(value[curr]);
			inorder(node[curr][1]);
		}
	}
}
