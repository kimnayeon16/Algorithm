import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int ans = 0;
		
		String s = bf.readLine();
		int[] cntWord = new int[26];
		for(int i=0; i<s.length(); i++) {
			cntWord[s.charAt(i) - '0' - 17]++;
		}
		
		for(int i=0; i<N - 1; i++) {
			String input = bf.readLine();
			int[] cntInput = new int[26];
			for(int j=0; j<input.length(); j++) {
				cntInput[input.charAt(j) - '0' - 17]++;
			}
			
			int cnt = 0;
			for(int k=0; k<26; k++) {
				cnt += Math.abs(cntWord[k] - cntInput[k]);
			}
			if(cnt <= 2 && Math.abs(s.length() - input.length()) <= 1) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
