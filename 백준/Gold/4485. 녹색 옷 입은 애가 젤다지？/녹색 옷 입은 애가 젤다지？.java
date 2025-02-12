import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node{
		private int x;
		private int y;
		private int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	static int N;
	static int[][] map;
	static int[][] dp;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int num = 1;
		
		while(true) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			map = new int[N][N];
			dp = new int[N][N];
			
			for(int a[]: dp) {
				Arrays.fill(a, Integer.MAX_VALUE);
			}
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve(0, 0);
			
			sb.append("Problem ").append(num++).append(": ").append(dp[N-1][N-1]).append("\n");
			
		}
		System.out.println(sb);
	}
	public static int solve(int x, int y) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		queue.offer(new Node(x,y, map[x][y]));
		
		dp[x][y] = map[x][y];
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();

			if(tmp.x == N-1 && tmp.y == N-1) return tmp.cost;
			
			for(int d=0; d<4; d++) {
				int nx = dx[d] + tmp.x;
				int ny = dy[d] + tmp.y;
				
				if(nx >=N || nx<0 || ny>=N || ny<0) continue;

				if(tmp.cost + map[nx][ny] < dp[nx][ny]) {
					dp[nx][ny] = tmp.cost + map[nx][ny];
					queue.offer(new Node(nx, ny, dp[nx][ny]));
				}
			}
		}
		return -1;
	}
}