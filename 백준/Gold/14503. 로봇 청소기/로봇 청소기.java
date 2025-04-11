import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(bf.readLine());
			for(int m=0; m<M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		cleaning(r,c,d);
		System.out.println(ans);
	}
	
	public static void cleaning(int r, int c, int a) {
//		1. 현재 칸이 아직 청소되지 않은 경우, 청소하기
		if(arr[r][c] == 0) {
			arr[r][c] = 2;
			ans++;
		}
		
//		3. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
		for(int d=0; d<4; d++) {
			a = (a+3) % 4;
			int nx = dx[a] + r;
			int ny = dy[a] + c;
			
			if(0<=nx && nx<N && 0<=ny && ny<M && arr[nx][ny] == 0) {
				cleaning(nx,ny,a);
				return;		
			}
		}
		
//		2. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
		int back = (a + 2) % 4;
		int p = r + dx[back];
		int q = c + dy[back];
		
		if(0<=p && p<N && 0<=q && q<M && arr[p][q] != 1) {
			cleaning(p,q,a);
		}
	}
}
