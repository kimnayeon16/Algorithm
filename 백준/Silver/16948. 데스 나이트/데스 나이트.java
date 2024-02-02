import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int min = Integer.MIN_VALUE;
	static int[] dx = {-2, -2, 0, 0, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -1, 1};
	static int[][] array;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		
		array = new int[N][N];
		visited = new boolean[N][N];
		
		System.out.println(bfs(r1, c1, r2, c2));
		
		
//		System.out.println(min);
		
		
	}

	private static int bfs(int r1, int c1, int r2, int c2) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {r1, c1, 0});
		visited[r1][c1] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.remove();
			
			for(int d=0; d<6; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];
				
				if(0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny]) {
					queue.add(new int[] {nx,ny,tmp[2]+1});
					visited[nx][ny] = true;
					min = Math.max(min, tmp[2]+1);
				}
				if(nx == r2 && ny == c2) return min;
			}
		}
		return -1;
	}
}