package algorithm_logic.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PR1 {
	static class Node {
		int left;
		int right;
		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	
	static class Node2 extends Node {
		int parent;

		public Node2(int left, int right, int parent) {
			super(left, right);
			this.parent = parent;
		}
	}
	
	public static void main(String[] args) {
		Node node1 = new Node2(10, 15, 1);
		Node node2 = new Node2(20, 25, 1);
		List<Node> list = new ArrayList<>();
		List<Node> list2 = List.of(node1, node2);
		
		list.add(node1);
		list.add(node2);
		System.out.println("Before list1 : " + list);
		list.set(0, new Node(5, 5));
		System.out.println("After list1 : " + list);
		
		System.out.println("Before list2 : " + list2);
//		list2.set(0, new Node(5, 5));
//		System.out.println("After list2 : " + list2);
		
		Set<Node> nodeSet = new HashSet<>();
//		nodeSet.add(node1);
		System.out.println(nodeSet.add(node1));
		System.out.println(nodeSet.add(node1));
		
		Set<Node> nodeSet2 = new TreeSet<>();
	}
}
