package com.monirthought.graph.dfs;

import java.util.LinkedList;

/**
 * DFS algorithm to final all possible paths between two vertex. Assumed that the
 * given graph has no cycle.
 * 
 * @author Moniruzzaman Md
 *
 */
public class DFS {

	/* Boolean array to avoid duplicate process of each node */
	private boolean visited[];

	/* We use adjacency list representation for the graph */
	private LinkedList<Integer> link[];

	/* We use this array to build the path */
	private int path[];

	public DFS(int totalNode) {

		/* Node number start with 1, so for 20 node, our array size must be 21 */
		/* Mark all the vertices as not visited, by default all are false */
		visited = new boolean[totalNode + 1];
		path = new int[totalNode + 1];
		link = new LinkedList[totalNode + 1];

		/* Initialize each linkedList */
		for (int i = 1; i <= totalNode; i++) {
			link[i] = new LinkedList<Integer>();
		}
	}

	/**
	 * Print the path
	 * 
	 * @param level
	 */
	public void printPath(int level) {
		for (int i = 0; i <= level; i++) {
			System.out.print(this.path[i] + " ");
		}
		System.out.println("");
	}

	/**
	 * Perform DFS to find all possible paths between start and target node
	 * 
	 * @param current
	 * @param target
	 * @param level, for indexing each node in path array 
	 */
	public void performDFS(int current, int target, int level) {

		path[level] = current;
		if (current == target) {
			this.printPath(level);
			return;
		}

		/* Marked the current node as visited */
		this.visited[current] = true;

		/* Get all adjacent node of the dequeued node current */
		/*
		 * If a adjacent has not been visited yet, then mark it visited and enqueue it
		 */
		for (int i = 0; i < link[current].size(); i++) {
			int adjacent = link[current].get(i);
			if (!this.visited[adjacent]) {
				performDFS(adjacent, target, level + 1);
			}
		}

		/*
		 * Unmarked the current node as visited as this node can be visited from other
		 * node
		 */
		this.visited[current] = false;

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

	public static void main(String[] args) {

		DFS dfs = new DFS(7);

		dfs.addEdage(1, 2);
		dfs.addEdage(1, 7);
		dfs.addEdage(1, 3);
		dfs.addEdage(2, 5);
		dfs.addEdage(3, 7);
		dfs.addEdage(5, 4);
		dfs.addEdage(1, 4);
		dfs.addEdage(4, 3);
		dfs.addEdage(4, 6);
		dfs.addEdage(4, 7);
		dfs.addEdage(6, 7);
		dfs.addEdage(5, 7);

		/* Finding all path between 1 and 7 */
		dfs.performDFS(1, 7, 0);

	}

}
