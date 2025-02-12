import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		private int idx;
		private int cost;
		private int item;
		
		public Node(int idx, int cost, int item) {
			this.idx = idx;
			this.cost = cost;
			this.item = item;
		}
		
		public String toString() {
			return "현재 idx = " + idx + ", 현재 비용 = " + cost;
		}
	}
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int n;
	static int m;
	static int[] items;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		items = new int[n+1];
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<=n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, cost, 0));
			graph.get(to).add(new Node(from, cost, 0));
		}
		
		int ans = 0;
		for(int i=1; i<=n; i++) {
			ans = Math.max(ans, solve(i));
		}
		System.out.println(ans);
		
	}
	public static int solve(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		queue.add(new Node(start, 0, items[start]));
		dist[start] = items[start];
		
		boolean[] visited = new boolean[n+1];
		visited[start] = true;

		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			for(Node next: graph.get(tmp.idx)) {
				if(next.cost + tmp.cost <= m) {
					queue.add(new Node(next.idx, next.cost + tmp.cost, tmp.item + items[next.idx]));
					dist[start] += items[next.idx];
					visited[next.idx] = true;
				}
			}
		}
		int sum = 0;
		for(int i=1; i<=n; i++) {
			if(visited[i]) sum += items[i];
		}
		return sum;
		
	}
}