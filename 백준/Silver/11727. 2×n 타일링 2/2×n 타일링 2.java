import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N+1];
		
		dp[1] = 1;
		if(N != 1) dp[2] = 3;
		
		for(int n=3; n<=N; n++) {
			dp[n] = (dp[n-1] + dp[n-2] * 2) % 10007;
		}
		
		System.out.println(dp[N] % 10007);
	}
}