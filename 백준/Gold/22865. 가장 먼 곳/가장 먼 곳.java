import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node>{
		private int idx;
		private int cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int N;
	static int A;
	static int B;
	static int C;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		int M = Integer.parseInt(bf.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			graph.get(d).add(new Node(e,l));
			graph.get(e).add(new Node(d,l));
		}
		
		System.out.println(solve());
	}
	private static int solve() {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(A, 0));
		queue.add(new Node(B, 0));
		queue.add(new Node(C, 0));
		
		dist[A] = dist[B] = dist[C] = 0;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if(dist[tmp.idx] < tmp.cost) continue;
			
			for(Node next: graph.get(tmp.idx)) {
				if(dist[next.idx] > tmp.cost + next.cost) {
					dist[next.idx] = tmp.cost + next.cost;
					queue.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for(int i=1; i<=N; i++) {
			if(dist[i] > max) {
				max = dist[i];
				idx = i;
			}
		}
		return idx;
	}
}