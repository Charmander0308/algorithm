package day08_0813.SWEA.FFAO1232;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int[][] node;
	static String[] value;
	static String expression;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day08_0813/SWEA/FFAO1232/input.txt");
		Scanner sc = new Scanner(file);
		int T = 1;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			sc.nextLine();
			
			node = new int[N+1][3];	//0:왼자, 1:오자, 2:부모 
			value = new String[N+1];
			
			for(int i = 1; i < N+1; i++) {
				String line = sc.nextLine();
				StringTokenizer st = new StringTokenizer(line);
				
				int parent = Integer.parseInt(st.nextToken());
				value[i] = st.nextToken();
				
				while(st.hasMoreTokens()) {
					int child = Integer.parseInt(st.nextToken());
					if(node[i][0] == 0) {
						node[i][0] = child;
					} else if(node[i][1] == 0) {
						node[i][1] = child;
					}
					node[child][2] = parent;
				}
			}
			for(int i = 1; i < N+1; i++) {
				System.out.println(i+"번:"+Arrays.toString(node[i])+", 값:"+value[i]);
			}
			inorder(1);
			System.out.println(expression);
			
		}
		
	}
	public static void inorder(int n) {
		if(n != 0) {
			inorder(node[n][0]);
			expression += value[n];
			inorder(node[n][1]);
		}
	}

}
