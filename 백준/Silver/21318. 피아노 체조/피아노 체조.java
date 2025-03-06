import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N+1];
		int[] check = new int[N+1];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			if(arr[i] < arr[i-1]) {
				check[i] += 1;
			}
			check[i] += check[i-1];
		}
		
		int Q = Integer.parseInt(bf.readLine());
		for(int q=0; q<Q; q++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x == y) {
				sb.append(0).append("\n");
			}else {
				sb.append(check[y]-check[x]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
