import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int R;
	static int C;
	static int T;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		ArrayList<int[]> airCleaner = new ArrayList<int[]>();
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == -1) {
					airCleaner.add(new int[] {i,j});
				}
			}
		}
		
		for(int t=0; t<T; t++) {
			int[][] spread = new int[R][C];
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(arr[i][j] > 0) {
						spreadDust(i, j, spread);
					}
				}
			}
			//먼지 확산
			for(int a=0; a<R; a++) {
				for(int b=0; b<C; b++) {
					arr[a][b] += spread[a][b];
				}
			}
			
			
			//공기청정기 작동
//			첫번째 공기청정기(반시계)
			CounterClockwiseCleaner(airCleaner.get(0));
//			두번째 공기청정기(시계)
			clockwiseCleaner(airCleaner.get(1));
		}
		
		int ans = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] > 0) {
					ans += arr[i][j];
				}
			}
		}
		System.out.println(ans);
	}

//	반 시계 방향
	private static void CounterClockwiseCleaner(int[] air) {
		int x = air[0];
		int y = air[1];
		
//		왼쪽 열
		for(int i=x-1; i>0; i--) {
			arr[i][y] = arr[i-1][y];
		}
		
//		위 행
		for(int i=0; i<C-1; i++) {
			arr[0][i] = arr[0][i+1];
		}
		
//		오른쪽 열
		for(int i=0; i<x; i++) {
			arr[i][C-1] = arr[i+1][C-1];
		}
		
//		아래 행
		for(int i=C-1; i>y; i--) {
			arr[x][i] = arr[x][i-1];
			
			if(arr[x][i] == -1) {
				arr[x][i] = 0;
			}
		}
	}
	
//	시계 방향
	private static void clockwiseCleaner(int[] air) {
		int x = air[0];
		int y = air[1];
		
		
//		왼쪽 열
		for(int i=x+1; i<R-1; i++) {
			arr[i][y] = arr[i+1][y];
		}
		
//		아래 행
		for(int i=y; i<C-1; i++) {
			arr[R-1][i] = arr[R-1][i+1];
		}
		
//		오른쪽 열
		for(int i=R-1; i>x; i--) {
			arr[i][C-1] = arr[i-1][C-1];
		}
		
//		위 행
		for(int i=C-1; i>y; i--) {
			arr[x][i] = arr[x][i-1];
			
			if(arr[x][i] == -1) {
				arr[x][i] = 0;
			}
		}
	}

	private static void spreadDust(int x, int y, int[][] spread) {
		int cnt = 0;
		
		for(int d=0; d<4; d++) {
			int nx = dx[d] + x;
			int ny = dy[d] + y;
			
			if(nx<0 || nx>=R || ny<0 || ny>=C || arr[nx][ny] == -1) continue;
			
			cnt++;
			spread[nx][ny] += arr[x][y]/5;
		}
		arr[x][y] -= (arr[x][y]/5) * cnt;
	}
}