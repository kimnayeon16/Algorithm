import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = 1;
		
		while(start <= end && end < arr.length) {
			if(arr[end] - arr[start] >= M) {
				min = Math.min(min, arr[end] - arr[start]);
				start++;
			}else {
				end++;
			}
		}
		System.out.println(min);
	}
}