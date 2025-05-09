import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[] start = new int[N];
		int[] end = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			start[i] = Integer.parseInt(st.nextToken());
			end[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(start);
		Arrays.sort(end);
		
		int room = 0;
		int i = 0;
		int j = 0;
		
		while(i < N) {
			if(start[i] < end[j]) {
				room++;
				i++;
			}else {
				i++;
				j++;
			}
		}
		System.out.println(room);
	}
}
