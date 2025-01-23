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
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M];
		int start = 1;
		int end = arr[M-1];
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			end = Math.max(end, arr[i]);
		}
//		Arrays.sort(arr);
		
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			int cnt = 0;
			for(int i=0; i<M; i++) {
				cnt += arr[i] / mid;
				
				if(arr[i] % mid !=0) cnt++;
			}
			
			if(cnt > N) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		System.out.println(start);
	}
}