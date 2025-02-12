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
		
		public Node(int idx, int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
	
	static ArrayList<ArrayList<Node>> graph;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());

		graph = new ArrayList<ArrayList<Node>>();
		cnt = new int[N+1];
		Arrays.fill(cnt, Integer.MAX_VALUE);
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, weight));
		}
		
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		solve(start);
		System.out.println(cnt[end]);
		
	}
	
	public static void solve(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		
		queue.add(new Node(start, 0));
		cnt[start] = 0;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if(tmp.cost > cnt[tmp.idx]) continue;
			
			for(Node next: graph.get(tmp.idx)) {
				if(cnt[next.idx] > cnt[tmp.idx] + next.cost) {
					cnt[next.idx] = cnt[tmp.idx] + next.cost;
					queue.add(new Node(next.idx, cnt[next.idx]));
				}
			}
		}
	}
}