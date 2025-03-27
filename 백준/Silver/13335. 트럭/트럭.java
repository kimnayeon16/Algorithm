import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Queue<Integer> truck = new LinkedList<Integer>();
		Queue<Integer> bridge = new LinkedList<Integer>();
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int time = 0;
		int bridgeWeight = 0;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<w; i++) {
			bridge.add(0);
		}
		
		while(!bridge.isEmpty()) {
			time++;
			
			bridgeWeight -= bridge.poll();
			if(!truck.isEmpty()) {
				if(truck.peek() + bridgeWeight <= L) {
					bridgeWeight += truck.peek();
					bridge.add(truck.poll());
				}else {
					bridge.add(0);
				}
			}
		}
		System.out.println(time);
	}
}
