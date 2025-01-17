import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];
		
		int max = Integer.MIN_VALUE;
		
		int num = 1;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<num; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			num++;
		}
		
		if(n == 1) {
			System.out.println(arr[0][0]);
			return;
		}
		
		for(int i=1; i<n; i++) {
			arr[i][0] += arr[i-1][0];
			arr[i][i] += arr[i-1][i-1];
			for(int j=1; j<i; j++) {
				arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
			}
		}
		
		for(int i=0; i<n; i++) {
			max = Math.max(max, arr[n-1][i]);
		}
		System.out.println(max);
	}
}