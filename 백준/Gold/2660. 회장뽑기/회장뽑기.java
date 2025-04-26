import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		int[][] dist = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(dist[i], 100);
			dist[i][i] = 0;
		}
		
		while(true) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1) break;
			
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	
		int[] score = new int[N+1];
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				score[i] = Math.max(score[i], dist[i][j]);
			}
			min = Math.min(min, score[i]);
		}
		ArrayList<Integer> person = new ArrayList<Integer>();
		for(int i=1; i<=N; i++) {
			if(min == score[i]) {
				person.add(i);
			}
		}
		
		sb.append(min).append(" ").append(person.size()).append("\n");
		for(int p : person) {
			sb.append(p).append(" ");
		}
		System.out.println(sb);
	}
}
