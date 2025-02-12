import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] list;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		cnt = new int[N+1];
		Arrays.fill(cnt, Integer.MAX_VALUE);
		
		for(int j=0; j<M; j++) {
			st = new StringTokenizer(bf.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
		}
		
		solve(X);
		
		for(int i=1; i<=N; i++) {
			if(cnt[i] == K) {
				sb.append(i).append("\n");
			}
		}
		if(sb.length() == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sb);
		}
		
		
	}
	public static void solve(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		cnt[start] = 0;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();

			for(int next: list[tmp]) {
				if(cnt[tmp] + 1 < cnt[next]) {
					cnt[next] = cnt[tmp] + 1;
					queue.offer(next);
				}
			}
		}
	}
}