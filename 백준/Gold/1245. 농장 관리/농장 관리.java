import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] farm;
	static boolean[][] visited;
	static boolean flag;
	
	static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
	static int[] dy = {0, -1, 0, 1, 1, -1, -1, 1};
	
	public static class Node{
		private int x;
		private int y;
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		farm = new int[N][M];
		visited = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(bf.readLine());
			for(int m=0; m<M; m++) {
				farm[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(farm[i][j] != 0 && !visited[i][j]) {
					flag = true;
					bfs(i,j);
					if(flag) result++;
				}
			}
		}
		System.out.println(result);
	}

	private static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(new Node(i,j));
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			for(int d=0; d<8; d++) {
				int nx = dx[d] + tmp.x;
				int ny = dy[d] + tmp.y;
				
				if(0>nx || nx>=N || 0>ny || ny>=M) continue;
				
				if(farm[nx][ny] > farm[tmp.x][tmp.y]) {
					flag = false;
				}
				
				if(farm[nx][ny] == farm[tmp.x][tmp.y] && !visited[nx][ny]) {
					queue.add(new Node(nx,ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
}