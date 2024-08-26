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
		
		int[] A = new int[N];
		int[] B = new int[M];
		
		int[] arr = new int[N+M];
		int cnt = 0;
		st = new StringTokenizer(bf.readLine());
		for(cnt=0; cnt<N; cnt++) {
			arr[cnt] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(; cnt<N+M; cnt++) {
			arr[cnt] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
//		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<arr.length; i++) {
			if(i == arr.length-1) {
				sb.append(arr[i]);				
			}else {
				sb.append(arr[i]).append(" ");
			}
			
		}
		System.out.println(sb);
	}
}