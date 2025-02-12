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
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static ArrayList<ArrayList<Node>> revGraph = new ArrayList<ArrayList<Node>>();
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
			revGraph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, cost));
			revGraph.get(to).add(new Node(from, cost));
		}
		
		int[] fromX = solve(graph, X);
		int[] toX = solve(revGraph, X);
		
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans, fromX[i] + toX[i]);
		}
		System.out.println(ans);
		
	}
	public static int[] solve(ArrayList<ArrayList<Node>> graph, int start) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		int[] cnt = new int[N+1];
		Arrays.fill(cnt, Integer.MAX_VALUE);
		
		queue.add(new Node(start, 0));
		cnt[start] = 0;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if(tmp.cost > cnt[tmp.idx]) continue;
			
			for(Node next: graph.get(tmp.idx)) {
				if(cnt[next.idx] > tmp.cost + next.cost) {
					cnt[next.idx] = tmp.cost + next.cost;
					queue.add(new Node(next.idx, cnt[next.idx]));
				}
			}
		}
		return cnt;
	}
}