import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		int min = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int pfSum[] = new int[N+2];
		for(int i=1; i<=N; i++) {
			pfSum[i] = pfSum[i-1] + arr[i-1];
		}
		
		int start = 1;
		int end = 1;
		
		int sum = pfSum[start];
		
		while(start <= end && end <= N) {
			if(sum >= M) {
				min = Math.min(min, end-start+1);
				start++;
			}else {
				end++;
			}
			sum = pfSum[end] - pfSum[start-1];
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.print(min);
		}
	}
}