import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		dp[0] = arr[0];
		
		int max = Integer.MIN_VALUE;
		int ans = dp[0];
		for(int i=1; i<N; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
