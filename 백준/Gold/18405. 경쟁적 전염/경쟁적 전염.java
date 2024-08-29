import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
	static int[][] map;
	
	static int S;
	static int X;
	static int Y;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0 ,-1};

	public static class Node implements Comparable<Node>{
		private int virusType;
		private int x;
		private int y;
		private int time;
		
		public Node(int virusType, int x, int y, int time) {
			this.virusType = virusType;
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.virusType - o.virusType;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		ArrayList<Node> al = new ArrayList<Node>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0) {
					al.add(new Node(map[i][j], i, j, 0));
				}
			}
		}
		
		Collections.sort(al);
		
		st = new StringTokenizer(bf.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		bfs(al);
		
		System.out.println(map[X-1][Y-1]);
	}
	
	public static void bfs(ArrayList<Node> al) {
		Queue<Node> queue = new LinkedList<Node>(al);
		
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if(tmp.time == S) {
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nx = dx[d] + tmp.x;
				int ny = dy[d] + tmp.y;
				
				if(0>nx || nx>=N || 0>ny || ny>=N) continue;
				
				if(map[nx][ny] == 0) {
					queue.add(new Node(tmp.virusType, nx, ny, tmp.time+1));
					map[nx][ny] = tmp.virusType;
				}
			}
		}
		
	}
}