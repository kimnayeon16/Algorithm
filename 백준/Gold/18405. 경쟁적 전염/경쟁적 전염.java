import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int K;
	static int S;
	static int[][] map;
	static boolean[][] visited;
	static List<Virus> list;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static class Virus implements Comparable<Virus>{
		private int virusType;
		private int x;
		private int y;
		private int cnt;
		
		public Virus(int virusType, int x, int y, int cnt) {
			this.virusType = virusType;
			this.x = x;
			this.y = y;	
			this.cnt = cnt;
		}

		
		@Override
		public int compareTo(Virus o) {
			return this.virusType - o.virusType;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<Virus>();
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0) {
					list.add(new Virus(map[i][j], i, j, 0));
				}
			}
		}
		
		Collections.sort(list);
		
		st = new StringTokenizer(bf.readLine());
		S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.println(map[X-1][Y-1]);
	}
	
	public static void bfs() {
		Queue<Virus> queue = new LinkedList<>(list);
		
		
		while(!queue.isEmpty()) {
			Virus tmp = queue.poll();
			
			if(tmp.cnt == S) break;
			
			for(int d=0; d<4; d++) {
				int nx = dx[d] + tmp.x;
				int ny = dy[d] + tmp.y;
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				
				if(map[nx][ny] == 0) {
					map[nx][ny] = tmp.virusType;
					queue.add(new Virus(map[nx][ny], nx, ny, tmp.cnt+1));
				}
			}
		}
	}
}