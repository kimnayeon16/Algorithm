import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		for(int i=1; i<=N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		int[][] dp = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			for(int w=1; w<=K; w++) {
                dp[i][w] = dp[i-1][w];
				if(w - weight[i] >= 0) {
					dp[i][w] = Math.max(dp[i][w], dp[i-1][w-weight[i]]+value[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}