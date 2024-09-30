import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static int[] choice;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		choice = new int[M];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		findNum(0,0);
		System.out.println(sb);
	}
	private static void findNum(int depth, int start) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(choice[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int before = -1;
		for(int i=start; i<N; i++) {
			if(before == nums[i]) continue;
			
			before = nums[i];
			choice[depth] = nums[i];
			findNum(depth+1, i);
		}
	}
}