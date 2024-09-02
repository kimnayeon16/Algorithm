import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][3];
		
		int[][] minArr = new int[N][3];
		int[][] maxArr = new int[N][3];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(i ==0) {
					maxArr[0][j] = arr[i][j];
					minArr[0][j] = arr[i][j];
				}
			}
		}
		
		for(int n=1; n<N; n++) {
			//0열
			maxArr[n][0] = Math.max(maxArr[n-1][0], maxArr[n-1][1]) + arr[n][0];
			minArr[n][0] = Math.min(minArr[n-1][0], minArr[n-1][1]) + arr[n][0];
			
			//1열
			maxArr[n][1] = Math.max(maxArr[n-1][0], Math.max(maxArr[n-1][1], maxArr[n-1][2])) + arr[n][1];
			minArr[n][1] = Math.min(minArr[n-1][0], Math.min(minArr[n-1][1], minArr[n-1][2])) + arr[n][1];
			
			
			//2열
			maxArr[n][2] = Math.max(maxArr[n-1][2], maxArr[n-1][1]) + arr[n][2];
			minArr[n][2] = Math.min(minArr[n-1][2], minArr[n-1][1]) + arr[n][2];
		}

		for(int i=0; i<3; i++) {
			max = Math.max(max, maxArr[N-1][i]);
			min = Math.min(min, minArr[N-1][i]);
		}
		
		System.out.println(max +" " + min);
		
	}
}