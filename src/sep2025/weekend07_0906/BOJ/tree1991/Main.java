package sep2025.weekend07_0906.BOJ.tree1991;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	//부모,(왼자, 오자) 로 저장
	static Map<Character, Node> tree = new HashMap<>();	
	
	static class Node {
		char left;
		char right;

		public Node(char left, char right) {
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//저장
		for(int i=1; i<=N; i++) {
			char parent = sc.next().charAt(0);
			char left = sc.next().charAt(0);
			char right = sc.next().charAt(0);
			tree.put(parent, new Node(left, right));
		}
		//'A'부터 전위순회
		preOrder('A');
		System.out.println();
		//중위순회
		inOrder('A');
		System.out.println();
		//후위순회
		postOrder('A');
		System.out.println();
	}
	
	public static void preOrder(char c) {
		if(c == '.') return;
		System.out.print(c);
		Node children = tree.get(c);
		preOrder(children.left);
		preOrder(children.right);
	}
	
	public static void inOrder(char c) {
		if(c == '.') return;
		Node children = tree.get(c);
		inOrder(children.left);
		System.out.print(c);
		inOrder(children.right);
	}
	
	public static void postOrder(char c) {
		if(c == '.') return;
		Node children = tree.get(c);
		postOrder(children.left);
		postOrder(children.right);
		System.out.print(c);
	}
	
}
