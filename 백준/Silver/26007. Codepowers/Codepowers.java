import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		arr[0] = X;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
			if(arr[i] < K) {
				sum[i] = sum[i-1]+1;
			}else {
				sum[i] = sum[i-1];				
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			if(arr[start] < K) {
				sb.append(sum[end-1]-sum[start] + 1).append("\n");
			}else {
				sb.append(sum[end-1]-sum[start]).append("\n");
			}
		}
		System.out.println(sb);
	}
}