import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		
		int min = 0;
		for(int i=2; i<=n; i++) {
			min = Integer.MAX_VALUE;
			
			for(int j=1; j*j<=i; j++) {
				int tmp = i - j*j;
				min = Math.min(min, dp[tmp]);
			}
			dp[i] = min + 1;
		}
		System.out.println(dp[n]);
	}
}
