import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> sleep = new ArrayList<Integer>();
		ArrayList<Integer> student = new ArrayList<Integer>();
		
		int[] cnt = new int[N+3];
		int[] visited = new int[N+3];
		
		st = new StringTokenizer(bf.readLine());
		for(int k=0; k<K; k++) {
			sleep.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int q=0; q<Q; q++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			if(!sleep.contains(tmp)) {
				student.add(tmp);				
			}
		}

//		조는 학생 2
		for(int i=0; i<K; i++) {
			visited[sleep.get(i)] = 2;
		}
		
//		출석 코드 1
		for(int i=0; i<student.size(); i++) {
			int tmp = student.get(i);
			
			for(int j=tmp; j<N+3; j+=tmp) {
				if(visited[j] != 2) {
					visited[j] = 1;					
				}
			}
		}
		
		
//		누적합 구하기
		for(int i=3; i<N+3; i++) {
			if(visited[i] != 1) {
				cnt[i] = cnt[i-1] + 1;
			}else {
				cnt[i] = cnt[i-1];
			}
		}
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(bf.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
//			if(S == 3 && )
			sb.append(cnt[E] - cnt[S-1]).append("\n");
		}
		System.out.println(sb);
	}
}
