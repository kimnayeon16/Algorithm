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
		
		int[] things = new int[N];
		
		Boolean isFriday = false;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			if(input == C) {
				things[i] = 0;
			}else {
				things[i] = input;
			}
		}
		
		Arrays.sort(things);
		
		if(things[0] == 0) {
			System.out.println(1);
			return;
		}
		
		int start = 0;
		int end = N-1;
		
		while(start < end) {
			int sum = things[start] + things[end];
			
			if(sum == C) {
				isFriday = true;
				break;
				
			}else if(sum > C) {
				end--;
			}else {
				int s = start+1; int e = end-1; int c = C - sum;
				
				while(s <= e) {
					int mid = (s+e)/2;
					
					if(things[mid] == c) {
						System.out.println(1);
						return;
					}else if(things[mid] > c) {
						e = mid-1;
					}else {
						s = mid+1;
					}
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