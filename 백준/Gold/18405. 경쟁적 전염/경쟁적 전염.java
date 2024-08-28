import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Node>[] virus;
	static ArrayList<Node>[] virusTemp;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static class Node{
		private int virusNum;
		private int x;
		private int y;
		
		public Node(int virusNum, int x, int y) {
			this.virusNum = virusNum;
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		virus = new ArrayList[K+1];
		virusTemp = new ArrayList[K+1];
		
		for(int v=1; v<=K; v++) {
			virus[v] = new ArrayList<>();
			virusTemp[v] = new ArrayList<>();
		}
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(bf.readLine());
			for(int k=0; k<N; k++) {
				map[n][k] = Integer.parseInt(st.nextToken());
				if(map[n][k] != 0) {
//					System.out.println(map[n][k]);
					virus[map[n][k]].add(new Node(map[n][k], n,k));
				}
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		
//		System.out.println(virus[2].get(0).x + " " + virus[2].get(0).y);
		
		for(int s=0; s<S; s++) { // s초만큼 반복
//			System.out.println("1번 :virus 사이즈: " + virus[1].size());
//			System.out.println("2번 :virus 사이즈: " + virus[2].size());
//			System.out.println("3번 :virus 사이즈: " + virus[3].size());
			
			bfs();
			
//			System.out.println((s+1) + "초 후");
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<K; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		
		System.out.println(map[X-1][Y-1]);
		
		
		
	}
	public static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i=1; i<=K; i++) {
			for(int j=0; j<virus[i].size(); j++) {
				int x = virus[i].get(j).x;
				int y = virus[i].get(j).y;
				queue.add(new Node(i, x, y));
				visited[x][y] =true;
			}
		}
//		System.out.println("큐 사이즈" + queue.size());
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = dx[d] + tmp.x;
				int ny = dy[d] + tmp.y;
			
				if(0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny]) {
					if(map[nx][ny] == 0) {
						map[nx][ny] = tmp.virusNum;
						virusTemp[tmp.virusNum].add(new Node(tmp.virusNum, nx, ny));
					}
				}
			}
		}
		
		for(int i=1; i<=K; i++) {
			virus[i].clear();
			virus[i].addAll(virusTemp[i]);
			virusTemp[i].clear();
		}
//		System.out.println("1번 :virus 사이즈: " + virus[1].size());
//		System.out.println("2번 :virus 사이즈: " + virus[2].size());
//		System.out.println("3번 :virus 사이즈: " + virus[3].size());
//		
	}
}