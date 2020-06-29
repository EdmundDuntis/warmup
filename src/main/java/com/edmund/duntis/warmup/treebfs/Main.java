package com.edmund.duntis.warmup.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<Node> queue = new LinkedList<Node>();
		Node root = ConstructTree();

		if (root == null) {
			return;
		}
		
		queue.add(root);

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur != null) {
				enqueueChildren(cur, queue);
				process(cur);
			}
		}
	}

	private static void enqueueChildren(Node cur, Queue<Node> q) {
		for (Node c : cur.children) {
			if (c != null) {
				q.add(c);
			}
		}
	}

	private static void process(Node curNode) {
		System.out.print(curNode.data + " ");
	}

	private static Node ConstructTree() {
		Node root = new Node("A");

		Node b = new Node("B");
		root.children[0] = b;
		root.children[1] = new Node("C");

		b.children[0] = new Node("D");
		b.children[1] = new Node("E");

		return root;
	}
}

class Node {
	private static int MaxChildCount = 10;

	public Node(String d) {
		this.data = d;
	}

	public String data;
	public Node[] children = new Node[MaxChildCount];
}

//问题2
//二叉树层级遍历，Node数据结构为
//class Node {
//public String data;
//public Node left;
//public Node right;
//}

//比如
//   A
//  / \
// B  C 
/// \
//D  E

//输出结果为 A B C D E
