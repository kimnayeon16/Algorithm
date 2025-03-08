import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		solve(0, 0, visited);
		
		System.out.println(ans);
		
		
	}
	public static void solve(int cnt, int sum, boolean[][] visited) {
		if(cnt == 3) {
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				int flower = 0;
				int tmpSum = 0;
				
				for(int d=0; d<4; d++) {
					int nx = dx[d] + i;
					int ny = dy[d] + j;
					
					if(nx < 0 || nx >= N || ny <0 || ny >= N || visited[nx][ny]) continue;
					flower++;
					tmpSum += arr[nx][ny];
				}
				
				if(flower == 4) {
					check(visited, i,j, true);
					solve(cnt+1, sum + tmpSum + arr[i][j], visited);
					check(visited, i, j, false);
				}else {
					continue;
				}
			}
		}
		
		
	}
	private static void check(boolean[][] visited, int x, int y, boolean b) {
		visited[x][y] = b;
		
		for(int d=0; d<4; d++) {
			int nx = dx[d] + x;
			int ny = dy[d] + y;
			
			visited[nx][ny] = b;
		}
		return;
	}
}
