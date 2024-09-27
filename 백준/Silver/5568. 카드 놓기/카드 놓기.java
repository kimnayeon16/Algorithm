import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static String[] cards;
	static boolean[] visited;
	static Set<String> set = new HashSet<String>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		k = Integer.parseInt(st.nextToken());
		cards = new String[n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			cards[i] = bf.readLine();
		}
		
		func("",0,0);
		System.out.println(set.size());
	}

	private static void func(String num, int start, int depth) {
		//k개 선택했다면
		if(depth == k) {
			set.add(num);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				func(num + cards[i], start+1, depth+1);
				visited[i] = false;
			}
		}
	}
}