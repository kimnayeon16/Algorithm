import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> things = new ArrayList<Integer>();
		
		Boolean isFriday = false;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			if(input == C) {
				things.add(0);
			}else {
				things.add(input);
			}
		}
		
		Collections.sort(things);
		
		if(things.get(0) == 0) {
			System.out.println(1);
			return;
		}
		
		int start = 0;
		int end = N-1;
		
		while(start < end) {
			int sum = things.get(start) + things.get(end);
			
			if(sum == C) {
				isFriday = true;
				break;
				
			}else if(sum > C) {
				end--;
			}else {
				if(things.indexOf(C - sum) > start && things.indexOf(C - sum) < end) {
					isFriday = true;
					break;
				}
				start++;
			}
		}
		
		if(isFriday) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}