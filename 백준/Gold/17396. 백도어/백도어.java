import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node>{
		private int idx;
		private long cost;
		
		public Node(int idx, long cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(cost, o.cost);
		}
	}
	
	static int N;
	static List<List<Node>> graph = new ArrayList<List<Node>>();
	static int[] vision;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		vision = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			vision[i] = Integer.parseInt(st.nextToken());
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b,t));
			graph.get(b).add(new Node(a,t));
		}
		
		System.out.println(solve(0));
		
	}
	public static long solve(int start) {
		long[] dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;
		
		boolean[] visited = new boolean[N];
		for(int i=0; i<N; i++) {
			if(vision[i] == 1) {
				visited[i] = true;
			}
		}
		visited[N-1] = false;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if(visited[tmp.idx]) continue;
			
			if(tmp.cost > dist[tmp.idx]) continue;
			
			for(Node next: graph.get(tmp.idx)) {
				if(vision[next.idx] == 0 || next.idx == N-1) {
					if(!visited[next.idx] && dist[next.idx] > tmp.cost + next.cost) {
						dist[next.idx] = tmp.cost + next.cost;
						queue.add(new Node(next.idx, dist[next.idx]));
					}
				}
			}
		}
		
		if(dist[N-1] == Long.MAX_VALUE) {
			return -1;
		}else {
			return dist[N-1];
		}
	}
}