import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		private int person;
		private int depth;
		
		public Node(int person, int depth) {
			this.person = person;
			this.depth = depth;
		}
	}
	
	static int N;
	static ArrayList<ArrayList<Integer>> al;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(bf.readLine());
		al = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=N; i++) {
			al.add(new ArrayList<Integer>());
		}
		
		while(true) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1) break;
			al.get(a).add(b);
			al.get(b).add(a);
			
		}
		
		int[] max = new int[N+1];
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			max[i] = solve(i);
			min = Math.min(min, max[i]);
		}
		
		ArrayList<Integer> all = new ArrayList<Integer>();
		for(int i=1; i<=N; i++) {
			if(min == max[i]) {
				all.add(i);
			}
		}
		sb.append(min).append(" ").append(all.size()).append("\n");
		for(int i=0; i<all.size(); i++) {
			sb.append(all.get(i)).append(" ");
		}
		System.out.println(sb);
//		System.out.println(Arrays.toString(max));
	}

	private static int solve(int i) {
		Queue<Node> queue = new LinkedList<Node>();
		boolean[] visited=  new boolean[N+1];
		
		queue.add(new Node(i,0));
		visited[i] = true;
		
		int m = 0;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			m = Math.max(m, tmp.depth);
			
			for(int next : al.get(tmp.person)) {
				if(!visited[next]) {
					queue.add(new Node(next, tmp.depth+1));
					visited[next] = true;
				}
			}
		}
		return m;
	}
}
