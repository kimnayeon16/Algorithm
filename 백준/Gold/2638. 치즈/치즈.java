import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] cnt;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		int cheese = 0;
		
		
		
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) cheese++;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited = new boolean[N][M];
				cnt = new int[N][M];
				if(arr[i][j] == 0 && !visited[i][j]) {
					bfs(i, j);
					ans++;
					
					for(int a=0; a<N; a++) {
						for(int b=0; b<M; b++) {
							if(cnt[a][b] >= 2) {
								arr[a][b] = 0;
								cheese--;
							}
							cnt[i][j] =0;
						}
					}

					
					if(cheese == 0) {
						System.out.println(ans);
						return;
					}
				}
			}
		}
		
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = dx[d] + tmp[0];
				int ny = dy[d] + tmp[1];
				
				if(nx>=N || nx<0 || ny>=M || ny<0 || visited[nx][ny]) continue;
				
				if(arr[nx][ny] == 0 && !visited[nx][ny]) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
				
				if(arr[nx][ny] == 1) {
					cnt[nx][ny]++;
				}
			}
		}
	}
}