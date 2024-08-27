import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String tc ="";
		while((tc = bf.readLine()) != null) {
			int x = Integer.parseInt(tc) * 10000000;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int[] lego = new int[n];
			
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				lego[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(lego);
			
			int start = 0;
			int end = n-1;
			
			int max = Integer.MIN_VALUE;
			
			int[] ans = new int[2];
			int result = 0;
			
			
			while(start < end) {
				int sum = lego[start] + lego[end];
				if(sum == x) {
//					System.out.println(lego[start] + " " + lego[end]);
					
					if(Math.abs(lego[start] - lego[end]) > max) {
						max = Math.abs(lego[start] - lego[end]);
						ans[0] = lego[start];
						ans[1] = lego[end];
					}
					
					start++;
					end--;
				}else if(sum > x) {
					end--;
				}else {
					start++;
				}
			}
			
			if(ans[0] == 0 && ans[1] == 0) {
				System.out.println("danger");
			}else {
				System.out.println("yes " + ans[0] + " " + ans[1]);
			}
		}
	}
}