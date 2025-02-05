import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int minus = 0;
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] <= 0) minus++;
		}

		Arrays.sort(arr);
		
		int range;
		if(minus % 2 == 0) {
			range = minus;
		}else {
			range = minus-1;
		}
		for(int i=0; i<range; i+=2) {
			sum += arr[i]*arr[i+1];
		}

		if((N - range) % 2 != 0) {
			sum += arr[range];
			range++;
		}
		
		for(int i=N-1; i>=range; i-=2) {
			if(arr[i]*arr[i-1] > arr[i]+arr[i-1]) {
				sum += arr[i]*arr[i-1];
			}else {
				sum += arr[i] + arr[i-1];
			}
			if(i == 0) {
				break;
			}
		}
		System.out.println(sum);
	}
}