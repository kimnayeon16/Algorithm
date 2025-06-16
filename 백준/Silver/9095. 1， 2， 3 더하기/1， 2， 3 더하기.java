import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[11];
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			for(int i=4; i<=N; i++) {
				arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
			}
			sb.append(arr[N]).append("\n");
		}
		System.out.println(sb);
	}
}
