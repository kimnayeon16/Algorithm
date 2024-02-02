import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R;
	static int C;
	static int N;
	static char[][] ans;
	static int[][] cnt;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		N = sc.nextInt();
		ans = new char[R][C];
		cnt = new int[R][C];
		
		for(int i=0; i<R; i++) {
			String s = sc.next();
			for(int j=0; j<C; j++) {
				if(s.charAt(j) == 'O') {
					cnt[i][j] = 1;
				}
			}
		}
		boom();
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(cnt[i][j] == 0) {
					ans[i][j] = '.';
				}else {
					ans[i][j] = 'O';
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void boom() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=2; i<=N; i++) {
			if(i % 2 == 0) {
				for(int j=0; j<R; j++) {
					for(int k=0; k<C; k++) {
						cnt[j][k]++;							
//						
					}
				}
			}else if(i % 2 != 0){
				for(int j=0; j<R; j++) {
					for(int k=0; k<C; k++) {
//						cnt[j][k]++;
						if(cnt[j][k] >=2) {
							queue.add(new int[] {j,k});
						}
					}
				}
				
				while(!queue.isEmpty()) {
					int[] tmp = queue.remove();
					cnt[tmp[0]][tmp[1]] = 0;
					for(int d=0; d<4; d++) {
						int nx = dx[d] +tmp[0];
						int ny = dy[d] + tmp[1];
						if(0<=nx && nx<R && 0<=ny && ny<C) {
							cnt[nx][ny] = 0;
						}
					}
				}
			}
		}
		
	}
}