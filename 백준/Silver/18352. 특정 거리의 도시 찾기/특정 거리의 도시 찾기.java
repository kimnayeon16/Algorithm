import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N; static int M;
	static int K; static int X;
	static int[] d;
	static ArrayList<ArrayList<Integer>> al;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();
		al = new ArrayList<ArrayList<Integer>>();
		d = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			al.add(new ArrayList<Integer>());
			d[i] = -1;
		}
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			al.get(a).add(b);
		}
		BFS(X);
		boolean check = false;
		for(int i=1; i<=N; i++) {
			if(d[i] == K) {
				System.out.println(i);
				check = true;
			}
		}
		
		if(!check) System.out.println(-1);
		
	}
	private static void BFS(int x) {
		d[x] = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i=0; i<al.get(now).size(); i++) {
				int nextNode = al.get(now).get(i);
				
				if(d[nextNode] == -1) {
					d[nextNode] = d[now] + 1;
					queue.add(nextNode);
				}
			}
		}
	}
}