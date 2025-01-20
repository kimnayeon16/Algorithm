import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int K = Integer.parseInt(bf.readLine());
		int [][] nums = new int[K][4];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<4; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			int sum = 0;
			int a = nums[i][0]-1;
			int b = nums[i][1]-1;
			int c = nums[i][2]-1;
			int d = nums[i][3]-1;
			
			for(int x=a; x<=c; x++) {
				for(int y=b; y<=d; y++) {
					sum += arr[x][y];
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}