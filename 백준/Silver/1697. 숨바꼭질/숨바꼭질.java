import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		System.out.println(bfs(N,0));
	}
	private static int bfs(int N, int cnt) {
		Queue<int[]> queue = new LinkedList<int[]>(); 
		
		queue.add(new int[] {N,0});
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(temp[0] == K) {
				return temp[1];
			}
						
			if(temp[0]+1 <= 100000 && !visited[temp[0]+1]) {
				visited[temp[0]+1] = true;
				queue.add(new int[] {temp[0]+1, temp[1]+1});
			}
			if(temp[0]-1 >= 0 && !visited[temp[0]-1]) {
				visited[temp[0]-1] = true;
				queue.add(new int[] {temp[0]-1, temp[1]+1});
			}
			if(temp[0]*2 <= 100000 && !visited[temp[0]*2]) {
				visited[temp[0]*2] = true;
				queue.add(new int[] {temp[0]*2, temp[1]+1});
			}
		}
		return 0;
	}
}