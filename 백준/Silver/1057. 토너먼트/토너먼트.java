import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int jimin = Integer.parseInt(st.nextToken());
		int hansu = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		while(jimin != hansu) {
			jimin = (jimin + 1) / 2;
			hansu = (hansu + 1) / 2;
			ans++;
		}
		System.out.println(ans);
	}
}