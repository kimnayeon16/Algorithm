import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Stack<Integer>[] stack = new Stack[7];
		
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		for(int i=0; i<=6; i++) {
			stack[i] = new Stack<Integer>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
//			stack이 비어있을 때
			if(stack[n].isEmpty()) {
				stack[n].add(p);
				ans++;
				continue;
			}
			
//			stack이 비어있지 않을 때
			if(stack[n].peek() < p) {
				stack[n].add(p);
				ans++;
			}else if(stack[n].peek() > p) {
				boolean check = true;
				while(!stack[n].isEmpty() && stack[n].peek() >= p) {
					if(stack[n].peek() == p) {
						check = false;
						break;
					}
					ans++;
					stack[n].pop();
				}
				
				if(check) {
					stack[n].add(p);
					ans++;					
				}
			}else {
				//같을 때는 아무도 동작도 하지 않음.
			}
		}
		System.out.println(ans);
	}
}
