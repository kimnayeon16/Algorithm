import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			queue.add(Integer.parseInt(bf.readLine()));
		}
		
		for(int i=0; i<T; i++) {
			if(queue.peek() < H) {
				sb.append("YES").append("\n").append(i);
				System.out.println(sb);
				return;
			}
			
			int tmp = queue.poll()/2;
			if(tmp == 0) {
				queue.add(1);
			}else {
				queue.add(tmp);
			}
		}
		
		if(queue.peek() < H) {
			sb.append("YES").append("\n").append(T);
		}else {
			sb.append("NO").append("\n").append(queue.peek());
		}
		System.out.println(sb);
		
	}
}
