import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int store = Integer.parseInt(bf.readLine());
		
		int[] stores = new int[store];
		
		for(int i=0; i<store; i++) {
			st = new StringTokenizer(bf.readLine());
			int arrow = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			stores[i] = checkDist(arrow, dist, W, H);
		}
		
		st = new StringTokenizer(bf.readLine());
		int dgArrow = Integer.parseInt(st.nextToken());
		int dgDist = Integer.parseInt(st.nextToken());
		int dong = checkDist(dgArrow, dgDist, W, H);
		int answer = 0;
		
		for(int i=0; i<store; i++) {
			int d = Math.abs(dong - stores[i]);
			answer += Math.min(d, 2*(W+H) - d);
		}
		
		System.out.println(answer);
	}
	
	public static int checkDist(int arrow, int dist, int W, int H) {
		switch(arrow) {
		case 1 : return dist;
		case 2 : return 2*W + H - dist;
		case 3 : return 2*(W + H) - dist;
		case 4 : return W + dist;
		}
		return 0;
	}
}
