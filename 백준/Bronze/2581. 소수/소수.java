import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[] isPrime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(bf.readLine());
		int N = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		
		findPrime(N);
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i=M; i<=N; i++) {
			if(isPrime[i]) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		
		sb.append(sum).append("\n").append(min);
		
		if(sum != 0) {
			System.out.println(sb);			
		}else {
			System.out.println(-1);
		}
	}
	
	public static void findPrime(int n) {
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2; i*i<=n; i++) {
			if(!isPrime[i]) continue;
			for(int j=i*i; j<=n; j+=i) {
				isPrime[j] = false;
			}
		}
	}
}
