import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static int[] choice;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		choice = new int[M];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = i+1;
		}

		findNum(0, 0);
		
		System.out.println(sb);
	}
	private static void findNum(int idx, int sidx) {
		if(sidx == M) {
			for(int i=0; i<M; i++) {
				sb.append(choice[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		if(idx == N) return;
		
		choice[sidx] = nums[idx];
		findNum(idx+1, sidx+1);
		findNum(idx+1, sidx);
	}
}