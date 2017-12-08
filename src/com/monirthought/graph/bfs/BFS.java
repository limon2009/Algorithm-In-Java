package com.monirthought.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First Traversal or BFS implementation
 * 
 * @author Moniruzzaman Md
 *
 */
public class BFS {

	/* Boolean array to avoid duplicate process of each node */
	private boolean visited[];

	/* We use adjacency list representation for the graph */
	private LinkedList<Integer> link[];

	public BFS(int totalNode) {

		/* Node number start with 1, so for 20 node, our array size must be 21 */
		/* Mark all the vertices as not visited, by default all are false */
		visited = new boolean[totalNode + 1];

		link = new LinkedList[totalNode + 1];

		/* Initialize each linkedList */
		for (int i = 1; i <= totalNode; i++) {
			link[i] = new LinkedList<Integer>();
		}
	}

	public void doBFS(int start) {

		/* Queue for our BFS algorithm */
		Queue<Integer> queue = new LinkedList<Integer>();

		/* Push the starting node */
		queue.add(start);

		/* Marked the current node as visited */
		visited[start] = true;

		System.out.print(start);

		while (!queue.isEmpty()) {

			/* Dequeue a vertex from queue and print it */
			int current = queue.poll();

			/* Get all adjacent node of the dequeued node current */
			/* If a adjacent has not been visited yet, then mark it visited and enqueue it */
			for (int i = 0; i < link[current].size(); i++) {
				int adjacent = link[current].get(i);
				if (!this.visited[adjacent]) {
					this.visited[adjacent] = true;
					queue.add(adjacent);
					System.out.print(" " + adjacent);
				}
			}

		}
	}

	/**
	 * Add each edge
	 * 
	 * @param start
	 *            - starting node
	 * @param end
	 *            - ending node
	 */
	public void addEdage(int start, int end) {
		link[start].add(end);
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BFS bfs = new BFS(7);
		bfs.addEdage(1, 2);
		bfs.addEdage(1, 7);
		bfs.addEdage(1, 3);
		bfs.addEdage(2, 5);
		bfs.addEdage(3, 7);
		bfs.addEdage(5, 4);
		bfs.addEdage(1, 4);
		bfs.addEdage(4, 3);
		bfs.addEdage(4, 6);
		bfs.addEdage(4, 7);
		bfs.addEdage(6, 7);
		bfs.addEdage(5, 7);
		bfs.addEdage(7, 2);
		bfs.doBFS(1);
	}

}
