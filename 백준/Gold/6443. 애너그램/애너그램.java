import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int len;
	static char[] word;
	static char[] choice;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		for(int n=0; n<N; n++) {
			String input = bf.readLine();
			len = input.length();
			word = new char[len];
			choice = new char[len];
			visited = new boolean[len];
			
			for(int i=0; i<len; i++) {
				word[i] = input.charAt(i);
			}
			Arrays.sort(word);
			findAnagram(0, "");
		}
		System.out.println(sb);
	}
	private static void findAnagram(int depth, String tmp) {
		if(len == depth) {
			sb.append(tmp).append('\n');
			return;
		}
		
		char before = '1';
		for(int i=0; i<len; i++) {
			if(visited[i] || before == word[i]) continue;
			
			before = word[i];
			visited[i] = true;
			findAnagram(depth+1, tmp+word[i]);
			visited[i] = false;
		}
	}
}