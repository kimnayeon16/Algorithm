import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		BigInteger[][] dp = new BigInteger[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0 || i==j) {
					dp[i][j] = BigInteger.ONE;
				}
				else {
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}