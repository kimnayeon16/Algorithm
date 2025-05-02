import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int max = 123456 * 2 + 1;
	static boolean[] isPrime = new boolean[max];
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Arrays.fill(isPrime, true);
		
		while(true) {
			int n = Integer.parseInt(bf.readLine());
			
			if(n == 0) break;
			
			findPrime();
			
			int cnt = 0;
			for(int i=n+1; i<=2*n; i++) {
				if(isPrime[i]) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void findPrime() {
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2; i*i<=max; i++) {
			if(!isPrime[i]) continue;
			for(int j=i*i; j<=max; j+=i) {
				isPrime[j] = false;
			}
		}
	}
}
