import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		private int x;
		private int y;
		private int cnt;
		private int wall;
		
		public Node(int x, int y, int cnt, int wall) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall;
		}
	}
	
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][][] visited;
	
	static int[] nx = {-1, 0, 1, 0};
	static int[] ny = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[2][N][M];
		
		for(int i=0; i<N; i++) {
			String input = bf.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(0,0,1,0));
		
		visited[0][0][0] = true;
		visited[1][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if(tmp.x == N-1 && tmp.y == M-1) {
				return tmp.cnt;
			}
			
			for(int d=0; d<4; d++) {
				int dx = nx[d] + tmp.x;
				int dy = ny[d] + tmp.y;
				
				if(dx>=N || dx<0 || dy>=M || dy<0) continue;
				
				if(arr[dx][dy] == 0) {
					if(!visited[tmp.wall][dx][dy]) {
						queue.add(new Node(dx,dy,tmp.cnt+1,tmp.wall));
						visited[tmp.wall][dx][dy] = true;
					}
				}else {
					if(!visited[1][dx][dy] && tmp.wall == 0) {
						queue.add(new Node(dx,dy,tmp.cnt+1,1));
						visited[1][dx][dy] = true;
					}
				}
			}
		}
		return -1;
	}
}