import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] rest = new int[N+2];
		ArrayList<Integer> dis = new ArrayList<Integer>();
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<=N; i++) {
			rest[i] = Integer.parseInt(st.nextToken());
		}
		rest[N+1] = L;
		Arrays.sort(rest);

		for(int i=1; i<N+2; i++) {
			dis.add(rest[i] - rest[i-1]);
		}
		
		int start = 1;
		int end = L;
		int answer = 0;
	
		while(start <= end) {
			int mid = (start + end) / 2;
			
			int cnt = 0;
			
			for(int d: dis) {
				if(d > mid) {
					cnt += (d - 1)/mid;
				}
			}
			
			if(cnt > M) {
				start = mid + 1;
			}else {
				answer = mid;
				end = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
