import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int start = 0;
		int end = N-1;
		
		int startAns = 0;
		int endAns = 0;
		
		int min = Integer.MAX_VALUE;
		
		while(start < end) {
			int sum = arr[start] + arr[end];
			
			if(Math.abs(min) > Math.abs(sum)) {
				min = sum;
			}
			
			if(min == sum) {
				startAns = start;
				endAns = end;
			}
			
			if(arr[start] + arr[end] > 0) {
				end--;
			}else if(arr[start] + arr[end] < 0) {
				start++;
			}else {
				break;
			}
		}
		System.out.println(arr[startAns] + " " + arr[endAns]);
	}
}