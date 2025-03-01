import java.util.Scanner;

public class Main {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int cnt = Math.min(N, M)/2;
		

		for(int i=0; i<R; i++) {
			for(int j=0; j<cnt; j++) {
				int x = j;
				int y = j;
				
				int value = arr[x][y];
				
				int idx=0;
				
				while(idx<4) {
					int nx = x + dx[idx];
					int ny = y + dy[idx];
					
					if(j<=nx && nx<N-j && j<=ny && ny<M-j) {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					}else {
						idx++;
					}
				}
				arr[j+1][j] = value;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}