import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int H;
	static int[][] arr;
	static int ans = 0;
	static boolean isFinish = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken()); //세로선의 개수
		M = Integer.parseInt(st.nextToken()); //가로선의 개수
		H = Integer.parseInt(st.nextToken()); //세로선마다 가로선을 놓을 수 있는 위치의 개수
		arr = new int[H+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1; //오른쪽으로 이동
			arr[x][y+1] = 2; //왼쪽으로 이동
		}
		
		//사다리를 0~3개까지 놓을 수 있음
		for(int n=0; n<=3; n++) {
			ans = n;
			dfs(1,0);
			if(isFinish) break;
		}
		
		if(isFinish) {
			System.out.println(ans);
		}else {
			System.out.println(-1);			
		}
	}

	private static void dfs(int x, int cnt) {
		if(isFinish) return;
		
		//사다리를 모두 사용했다면
		if(ans == cnt) {
			if(check()) isFinish = true;
			return;
		}
		
		//사다리를 모두 사용한게 아니라면 사다리를 더 놓으러 가야됨
		//가로선에 놓을 수 있는 사다리 개수만큼 반복 
		for(int i=x; i<=H; i++) {
			//세로선의 개수만큼 반복
			for(int j=1; j<N; j++) {
				//가로선 두 개가 연속으로 놓여질 수 없기 때문에 이미 연결된 가로선이 있는지 체크
				if(arr[i][j] == 0 && arr[i][j+1] == 0) {
					//가로선 추가
					arr[i][j] = 1;
					arr[i][j+1] = 2;
					
					dfs(i, cnt+1);
					
					//추가했던 가로선 제거
					arr[i][j] = arr[i][j+1] = 0;
				}
			}
		}
		
		
	}

	//i번에서 출발해서 i번으로 도착하는지 전부 확인
	private static boolean check() {
		//세로선의 개수만큼 반복
		for(int i=1; i<=N; i++) {
			int x = 1; int y = i;
			//
			for(int j=0; j<H; j++) {
				//1이면 오른쪽으로 이동
				if(arr[x][y] == 1) {
					y++;
					//2면 왼쪽으로 이동
				}else if(arr[x][y] == 2) {
					y--;
				}
				//열 이동 상관 없이 행 한칸 아래로 이동
				x++;
			}
			//i번에서 출발해서 i번에 도착하지 않는다면 false 리턴
			if(y != i) return false;
		}
		return true;
	}
}