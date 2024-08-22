import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[1000001];
		int max = 0;
		int sum = 0;
		
		int maxSit = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			nums[x] = g;
			maxSit = Math.max(maxSit, x);
			
		}
		
		for(int i=0; i<K*2+1 && i<=1000000; i++) {
			sum += nums[i];
		}
		max = sum;
		
		for(int start=0, end=K*2+1; end <= maxSit ; start++, end++) {
			
			sum -= nums[start];
			sum += nums[end];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
		
	}
}