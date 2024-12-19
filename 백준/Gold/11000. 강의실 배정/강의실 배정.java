import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> ll = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
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
					}else{
						pq.add(arr[i][1]);
						break;
					}
				}
			}
		}
		System.out.println(pq.size());
	}
}