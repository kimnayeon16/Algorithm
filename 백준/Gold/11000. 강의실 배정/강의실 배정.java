import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int cnt = 1;
		
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1]-o2[1]; 
				}else {
					return o1[0]-o2[0];
				}
			}
		});
		
		for(int i=0; i<N; i++) {
			if(pq.size() == 0) {
				pq.add(arr[i][1]);
			}else {
				for(int j=0; j<pq.size(); j++) {
					int num = pq.poll();
					if(num > arr[i][0]) {
						pq.add(arr[i][1]);
						pq.add(num);
						break;
					}else {
						pq.add(arr[i][1]);
						break;
					}
				}
			}
		}
		System.out.println(pq.size());
	}
}