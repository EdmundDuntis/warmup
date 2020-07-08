package com.edmund.duntis.warmup.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		// 构建树
		Node root = ConstructTree();

		// 简单情况短路操作
		if (root == null) {
			return;
		}

		// 正常情况下的遍历
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root); // root首先入队

		while (!queue.isEmpty()) {
			Node cur = queue.poll(); // 出队
			if (cur != null) {
				enqueueChildren(cur, queue); // 子节点入队
				process(cur); // 处理当前节点
			}
		}
	}

	/**
	 * 指定节点的子节点全部入队.
	 * 
	 * @param cur
	 * @param q
	 */
	private static void enqueueChildren(Node cur, Queue<Node> q) {
		for (Node c : cur.children) {
			if (c != null) { // 非空子节点入队
				q.offer(c);
			}
		}
	}

	/**
	 * 处理当前节点.
	 * 
	 * @param curNode
	 */
	private static void process(Node curNode) {
		System.out.print(curNode.data + " ");
	}

	/**
	 * 构建树.
	 * 
	 * @return
	 */
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

// Node 定义
class Node {
	private static int MaxChildCount = 10;

	public Node(String d) {
		this.data = d;
	}

	public String data;
	public Node[] children = new Node[MaxChildCount];
}

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
