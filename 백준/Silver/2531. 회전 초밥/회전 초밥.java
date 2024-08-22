import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> bob = new ArrayList<>();
		
		int N = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		int result = 0;
		
		
		for(int i=0; i<N; i++) {
			bob.add(sc.nextInt());
		}
		
		
		for(int i=0; i<N; i++) {
			int[] count = new int[d+1];
			int bobCount = 0;
			
			for(int j=0; j<k; j++) {
				count[bob.get((i+j) % N)]++;
			}
			
			count[c]++;
			
			for(int a=1; a<=d; a++) {
				if(count[a] != 0) {
					bobCount++;
				}
			}
			
			result = Math.max(result, bobCount);
		}
		
		System.out.println(result);
	}
}