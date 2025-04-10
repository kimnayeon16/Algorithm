import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(bf.readLine());
		int[] arr = new int[6];
		
		int widthMax = 0;
		int heightMax = 0;
		int idxWidth = 0;
		int idxHeight = 0;
		int disExtent = 1;
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(bf.readLine());
			int arrow = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			arr[i] = length;
			
			if(arrow == 1 || arrow == 2) {
				if(widthMax < length) {
					widthMax = length;
					idxWidth = i;
				}
			}
			if(arrow == 3 || arrow == 4) {
				if(heightMax < length) {
					heightMax = length;
					idxHeight = i;
				}
			}
		}
		
		if(idxWidth == 0) {
			disExtent *= Math.abs(arr[1] - arr[5]);
		}else if(idxWidth == 5) {
			disExtent *= Math.abs(arr[4] - arr[0]);
		}else {
			disExtent *= Math.abs(arr[idxWidth-1] - arr[idxWidth+1]);
		}
		
		if(idxHeight == 0) {
			disExtent *= Math.abs(arr[1] - arr[5]);
		}else if(idxHeight == 5) {
			disExtent *= Math.abs(arr[4] - arr[0]);
		}else {
			disExtent *= Math.abs(arr[idxHeight-1] - arr[idxHeight+1]);
		}

		System.out.println(((widthMax * heightMax) - disExtent) * K);
	}
}
