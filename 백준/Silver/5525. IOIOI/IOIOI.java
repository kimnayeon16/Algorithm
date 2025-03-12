import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		String word = bf.readLine();
		
		StringBuilder sb = new StringBuilder();
		sb.append("IOI");
		
		for(int i=1; i<N; i++) {
			sb.append("OI");
		}
		
		int len = sb.length();
		
		int ans = 0;
		for(int i=0; i<=M-len; i++) {
			String tmp = word.toString().substring(i, i+len);
			if(tmp.equals(sb.toString())) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
