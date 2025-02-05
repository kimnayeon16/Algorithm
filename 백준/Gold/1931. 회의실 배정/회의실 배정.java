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
		int[][] arr = new int[N][2];
		
		int cnt = 1;

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});
		
		int tmp = arr[0][1];
		for(int i=1; i<N; i++) {
			if(arr[i][0] >= tmp) {
				tmp = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}