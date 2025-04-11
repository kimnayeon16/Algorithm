import java.util.Scanner;

public class Main {
	static int[] dr = {-1,0,1,0}; //상우하좌(북동남서)
	static int[] dc = {0,1,0,-1};
	static int[][] arr;
	static int N; static int M;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		dfs(x,y,d);
		System.out.println(count);
	}
	private static void dfs(int r, int c, int d) {
		//현재 위치 청소
		if(arr[r][c] == 0) {
			arr[r][c] =2;
			count++;
		}
		
		
		boolean flag = false;
		int origin = d;
		
		for(int i=0; i<4; i++) {
			int direction = (d+3)%4;
			int nr = r + dr[direction];
			int nc = c + dc[direction];
			
			if(0<=nr && nr<N && 0<=nc && nc<M && arr[nr][nc]==0) {
				dfs(nr, nc, direction);
				flag = true;
				break;
			}
			d = (d +3)%4;
		}
		
		//네 방향 모두 청소가 되어있거나 벽인 경우
		if(!flag) {
			int back = (origin+2)%4;
			int bx = r + dr[back];
			int by = c + dc[back];
			
			if(0<=bx&& bx<N && 0<=by && by<M && arr[bx][by] != 1) {
				dfs(bx, by, origin);
			}
		}
		
		
	}

	
}