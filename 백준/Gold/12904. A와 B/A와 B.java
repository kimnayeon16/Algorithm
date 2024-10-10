import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder s = new StringBuilder(bf.readLine());
		StringBuilder t = new StringBuilder(bf.readLine());
		
		while(s.length() < t.length()) {
			if(t.charAt(t.length()-1) == 'A') {
				t.deleteCharAt(t.length()-1);
			}else {
				t.deleteCharAt(t.length()-1);
				t.reverse();
			}
		}
		System.out.println(s.toString().equals(t.toString()) ? 1: 0);
	}
}