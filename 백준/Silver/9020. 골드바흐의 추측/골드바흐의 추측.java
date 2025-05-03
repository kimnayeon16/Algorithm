import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static boolean[] isPrime = new boolean[10002];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> primeNumber = new ArrayList<Integer>();
		Arrays.fill(isPrime, true);
		findPrime();
		
		for(int i=2; i<=10000; i++) {
			if(isPrime[i]) primeNumber.add(i);
		}
		
		int T = Integer.parseInt(bf.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(bf.readLine());
			
			int left = 0;
			int right = primeNumber.size()-1;
			
			int bestA = 0, bestB = 0;
            int bestDiff = Integer.MAX_VALUE;
			
			while(left <= right) {
				int p = primeNumber.get(left);
				int q = primeNumber.get(right);
				int sum = p + q;
				
				if(sum == n) {
					int diff = q - p;
					if (diff < bestDiff) {
                        bestDiff = diff;
                        bestA = p;
                        bestB = q;
                    }
					left++;
                    right--;
				}else if(sum < n) {
					left++;
				}else {
					right--;
				}
			}
			sb.append(bestA).append(" ").append(bestB).append("\n");
		}
		System.out.println(sb);
	}

	private static void findPrime() {
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2; i*i<=10000; i++) {
			for(int j=i*i; j<=10000; j+=i) {
				if(!isPrime[j]) continue;
				isPrime[j] = false;
			}
		}
	}
}
