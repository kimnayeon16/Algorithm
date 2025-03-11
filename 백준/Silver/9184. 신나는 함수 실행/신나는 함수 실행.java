import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) {
				System.out.println(sb);
				return;
			}
			
			int result = w(a,b,c);
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append("\n");
		}
	}

	public static int[][][] dp = new int[21][21][21];
	private static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) return 1;
		
		if(a > 20 || b > 20 || c > 20) return w(20, 20, 20);
		
		if(dp[a][b][c] != 0) return dp[a][b][c];
		
		
		if(a < b && b < c) {
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}else {
			return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		}
	}
}
