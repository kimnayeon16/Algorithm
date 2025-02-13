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
		private int max;
		
		public Node(int idx, int cost, int max) {
			this.idx = idx;
			this.cost = cost;
			this.max = max;
		}
		
		public int compareTo(Node o) {
			return o.cost - this.cost;
		}
	}
	static int N;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken()); //교차로 개수
		int M = Integer.parseInt(st.nextToken()); //골목 개수
		int A = Integer.parseInt(st.nextToken()); //시작
		int B = Integer.parseInt(st.nextToken()); //끝
		int C = Integer.parseInt(st.nextToken()); //가진 돈
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, cost, 0));
			graph.get(to).add(new Node(from, cost, 0));
		}
		
		System.out.println(solve(A, B, C));
	}
	
	public static int solve(int start, int end, int goal) {
		int[] dist = new int[N+1];
		int max = -1;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(start, 0, 0));
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if(tmp.idx == end && tmp.cost <= goal && tmp.cost != 0) {
				max = Math.max(max, tmp.max);
			}
			
			for(Node next: graph.get(tmp.idx)) {
				if(next.cost + tmp.cost <= goal) {
					if(dist[next.idx] <= next.cost + tmp.cost) {
						dist[next.idx] = next.cost + tmp.cost;
						queue.add(new Node(next.idx, dist[next.idx], Math.max(tmp.max, next.cost)));
					}
				}
			}
		}
		return max;
		
	}
}