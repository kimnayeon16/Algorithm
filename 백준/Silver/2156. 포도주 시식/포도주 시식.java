import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[10001];
		int[] dp = new int[10001];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
			
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		int ans = Math.max(dp[1], dp[2]);
		
		for(int i=3; i<=n; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(arr[i-1] + dp[i-3] , dp[i-2]) + arr[i]);
			
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(dp[n]);
	}
}
