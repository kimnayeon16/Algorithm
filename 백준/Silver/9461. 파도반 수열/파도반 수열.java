import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(bf.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(bf.readLine());
			Long[] dp = new Long[101];
			
			dp[1] = dp[2] = dp[3] = (long) 1;
			dp[4] = dp[5] = (long) 2;

			for(int i=6; i<=N; i++) {
				dp[i] = dp[i-1] + dp[i-5];
			}
			
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}
}
