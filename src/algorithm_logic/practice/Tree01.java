package algorithm_logic.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tree01 {
	static class Children {
		String left, right;

		public Children(String left, String right) {
			this.left = left;
			this.right = right;
		}
	}
	static Map<String, Children> node;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		node = new HashMap<>();
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			node.put(sc.next(), new Children(sc.next(), sc.next()));
		}
		preOrder("A");
		System.out.println();
		inOrder("A");
		System.out.println();
		postOrder("A");
	} 
	
	static void preOrder(String s) {
		if(!s.equals(null) && !s.equals("*")) {
			System.out.print(s);
			preOrder(node.get(s).left);
			preOrder(node.get(s).right);
		}
	}
	static void inOrder(String s) {
		if(!s.equals(null) && !s.equals("*")) {
			preOrder(node.get(s).left);
			System.out.print(s);
			preOrder(node.get(s).right);
		}
	}
	static void postOrder(String s) {
		if(!s.equals(null) && !s.equals("*")) {
			preOrder(node.get(s).left);
			preOrder(node.get(s).right);
			System.out.print(s);
		}
	}
	
	
	static String input = "5\r\n"
			+ "A B C\r\n"
			+ "B D *\r\n"
			+ "C E *\r\n"
			+ "D * *\r\n"
			+ "E * *\r\n";
	

}
