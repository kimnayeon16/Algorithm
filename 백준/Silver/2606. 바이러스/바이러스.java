import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] virus;
	static boolean[] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		virus = new int[N+1][N+1];
		visited = new boolean[N+1];
		visited[1] = true;
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			virus[a][b] = 1;
			virus[b][a] = 1;
		}
		bfs(N);
		System.out.println(cnt);
	}

	private static void bfs(int N) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(1);
		
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(virus[tmp][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		
	}
}