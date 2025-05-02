import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static ArrayList<Integer> primeNumber = new ArrayList<Integer>();
	static boolean[] isPrime;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		prime(N);
		
		for(int i=2; i<=N; i++) {
			if(!isPrime[i]) continue;
			primeNumber.add(i);
		}
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		
		while(end < primeNumber.size()) {
			int startValue = primeNumber.get(start);
			int endValue = primeNumber.get(end);
			if(sum == N) {
				cnt++;
				sum -= startValue;
				start++;
			}else if(sum < N) {
				end++;
				sum += endValue;
			}else if(sum > N) {
				sum -= startValue;
				start++;
			}
		}
		
		if(primeNumber.contains(N)) cnt++;
		System.out.println(cnt);
	}
	
	public static void prime(int num) {
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2; i*i<=num; i++) {
			if(!isPrime[i]) continue;
			for(int j=i*i; j<=num; j+=i) {
				isPrime[j] = false;
			}
		}
	}
}