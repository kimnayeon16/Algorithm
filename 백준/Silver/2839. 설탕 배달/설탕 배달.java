import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//설탕 입력
		int N = Integer.parseInt(bf.readLine());
		//설탕 Nkg을 구하기 위해 하나 더 큰 배열 생성
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			//최소의 개수를 구해야하기 때문에 최소값을 큰 값으로 임의 설정
			min = 987654321;
			if(i>=3) min = Math.min(min, dp[i-3]+1);
			if(i>=5) min = Math.min(min, dp[i-5]+1);
            
			dp[i]=min;
		}
		if(min == 987654321) {
			System.out.println(-1);
		}else {
			System.out.println(dp[N]);
		}
	}
}
