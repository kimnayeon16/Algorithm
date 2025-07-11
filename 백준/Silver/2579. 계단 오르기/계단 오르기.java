import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		if(N == 1) {
			System.out.println(arr[1]);
		}else if(N == 2) {
			System.out.println(arr[1]+arr[2]);
		}else {
			dp[1] = arr[1];
			dp[2] = arr[1]+arr[2];
			dp[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
			
			for(int i=4; i<=N; i++) {
				dp[i] = Math.max(arr[i-1]+dp[i-3]+arr[i],dp[i-2]+arr[i]);
			}
			System.out.println(dp[N]);
			
		}
	}
}
