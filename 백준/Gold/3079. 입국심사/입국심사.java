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
		
		int[] time = new int[N];
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(time);
		
		long start = 0;
		long end = (long) time[N-1] * M;
		
		while(start <= end) {
			long mid = (start + end) / 2;
	
			long cnt = 0;
			for(int t : time) {
				cnt += mid / t;
				
				if(cnt > M) {
					break;
				}
			}
			
			if(cnt >= M) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		System.out.println(start);
	}
}
