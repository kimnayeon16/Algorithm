import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = bf.readLine();
		
		if(input.startsWith("_") || input.endsWith("_") || input.contains("__")) {
			System.out.println("Error!");
			return;
		}
		if(17 <= input.charAt(0)-'0' && input.charAt(0)-'0' <=42) {
			System.out.println("Error!");
			return;
		}
		
		
		Boolean isJava = false;
		Boolean isCpp = false;
		
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			if(Character.isUpperCase(c)) {
				isJava = true;
			}
			if(c == '_') {
				isCpp = true;
			}
		}
		
		if(isJava && isCpp) {
			System.out.println("Error!");
			return;
		}
		
		String[] s = input.split("_");
		
		if(s.length != 1) {
			for(int i=0; i<s.length; i++) {
				if(sb.length() == 0) {
					sb.append(s[i]);
				}else {
					sb.append(s[i].substring(0,1).toUpperCase()).append(s[i].substring(1));					
				}
			}
		}else {
			for(int i=0; i<s[0].length(); i++) {
				if(17 <= s[0].charAt(i)-'0' && s[0].charAt(i)-'0' <= 42) {
					sb.append("_").append(s[0].substring(i, i+1).toLowerCase());
				}else {
					sb.append(s[0].charAt(i));
				}
			}
		}
		if(sb.charAt(0) == '_') {
			System.out.println("Error!");
		}else {
			System.out.println(sb);
		}
	}
}
