import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String A;
	static int B;
	static int n;
	static int[] arr;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		A = st.nextToken();
		B = Integer.parseInt(st.nextToken());
		n = A.length();
		arr = new int[n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = A.charAt(i) - '0';
		}
//		System.out.println(Arrays.toString(arr));
		
		findNum(0, 0);
		if(max == Integer.MIN_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(max);			
		}
	}
	
	private static void findNum(int num, int depth) {
		if(depth == n) {
//			System.out.println(num);
			if(num < B && n == Integer.toString(num).length()) {
				max = Math.max(max, num);
			}
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				findNum(10*num + arr[i], depth+1);
				visited[i] = false;
			}
		}
	}
}