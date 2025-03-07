import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String input = bf.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		solve(arr, 0, 0, N, N);
		System.out.println(sb);
	}
	
	public static void solve(int[][] arr, int x1, int y1, int x2, int y2) {
		int zero = 0;
		int one = 0;
		
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				if(arr[i][j] == 0) {
					zero++;
				}else {
					one++;
				}
			}
		}
		
		//종료 조건
		if(zero + one == 1) {
			if(zero == 1) {
				sb.append("0");
			}else {
				sb.append("1");
			}
			return;
		}
		
		if(zero == 0) {
			sb.append("1");
			return;
		}else if(one == 0) {
			sb.append("0");
			return;
		}else {
			
			int midX = (x1+x2)/2;
			int midY = (y1+y2)/2;
			sb.append("(");
			solve(arr, x1, y1, midX, midY);
			solve(arr, x1, midY, midX, y2);
			solve(arr, midX, y1, x2, midY);
			solve(arr, midX, midY, x2, y2);
			sb.append(")");
		}
	}
}
