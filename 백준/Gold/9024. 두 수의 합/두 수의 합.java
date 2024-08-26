import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			String [] input = bf.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int K = Integer.parseInt(input[1]);
			
			String[] inputArr = bf.readLine().split(" ");			
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(inputArr[i]);
			}
			Arrays.sort(arr);
			
			int start = 0;
			int end = n-1;
			
			int min = Integer.MAX_VALUE;
			int cnt = 0;
			
			while(start < end) {
				int sum = arr[start] + arr[end];
				int abs = Math.abs(arr[start] + arr[end] - K);
				
				if(abs == min) {
					cnt++;
				}else if(min > abs){
					cnt = 1;
				}
				min = Math.min(abs, min);
				
				if(sum >= K) {
					end--;
				}else {
					start++;
				}
			}
			System.out.println(cnt);
		}
	}
}