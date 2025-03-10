import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N+1];
			st = new StringTokenizer(bf.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
			}
			
			int max = arr[K] - arr[0];
			for(int i=K+1; i<=N; i++) {
				max = Math.max(max, arr[i]-arr[i-K]);
			}
			System.out.println(max);
		}
	
}
