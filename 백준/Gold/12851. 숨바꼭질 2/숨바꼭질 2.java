import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int cnt = 0;
	static int time = Integer.MAX_VALUE;
	
	public static class Node{
		private int loc;
		private int time;
		
		public Node(int loc, int time) {
			this.loc = loc;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(time);
		System.out.println(cnt);
		
	}
	private static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		int[] visited = new int[100001];
		
		queue.add(new Node(N, 0));
		visited[N] = 1;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if(time < visited[tmp.loc]) continue;
			
			if(tmp.loc == K) {
				time = Math.min(time, tmp.time);
				
				if(time == tmp.time) {
					cnt++;
				}
				continue;
			}
			
			int[] arr = {tmp.loc-1, tmp.loc+1, tmp.loc*2};
			for(int next: arr) {
				if(next < 0 || next > 100000) continue;
				
				if(visited[next] == 0 || visited[next] == tmp.time + 1) {
					visited[next] = tmp.time+1;
					queue.add(new Node(next, tmp.time+1));
				}
			}
		}
	}
}