import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		func(0);
		System.out.println(min);
	}
	private static void func(int cnt) {
		if(cnt == N) {
			min = Math.min(min, getTaste());
			return;
		}
		
		visited[cnt] = true;
		func(cnt+1);
		
		visited[cnt] = false;
		func(cnt+1);
		
	}
	private static int getTaste() {
		int sour = 1;
		int bitter = 0;
		for(int i=0; i<N; i++) {
			if(visited[i]) {
				sour *= arr[i][0];
				bitter += arr[i][1];
			}
		}
		if(bitter == 0 && sour==1) return Integer.MAX_VALUE;
		return Math.abs(sour-bitter);
	}
}