import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		int[][] dist = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1; j<=N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
				
				if(dist[i][j] == 0) dist[i][j] = 100;
			}
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(dist[i][j] == 100) {
					sb.append("0 ");
				}else {
					sb.append("1 ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
