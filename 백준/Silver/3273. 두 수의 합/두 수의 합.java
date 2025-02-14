import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int X = sc.nextInt();
		int count = 0;
		
		for(int i=0; i<N-1; i++) {
			int num = X-arr[i];
			for(int j=i+1; j<N; j++) {
				if(num == arr[j]) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}