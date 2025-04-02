import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		Map<String, int[]> map = new HashMap<String, int[]>();
		map.put("R", new int[] {0,1});
		map.put("L", new int[] {0,-1});
		map.put("B", new int[] {-1,0});
		map.put("T", new int[] {1,0});
		map.put("RT", new int[] {1,1});
		map.put("LT", new int[] {1,-1});
		map.put("RB", new int[] {-1,1});
		map.put("LB", new int[] {-1,-1});
		
		String king = st.nextToken();
		char kingAlp = king.charAt(0);
		int kingNum = king.charAt(1) - '0';
		
		String stone = st.nextToken();
		char stoneAlp = stone.charAt(0);
		int stoneNum = stone.charAt(1) - '0';
		
		int N = Integer.parseInt(st.nextToken());


		for(int i=0; i<N; i++) {
			String input = bf.readLine();
			
			int[] tmp = map.get(input);
			int num = tmp[0];
			int alpha = tmp[1];
			
			kingAlp += alpha;
			kingNum += num;
			
//			king이 범위를 넘어갔는지 체크
			if(kingAlp < 'A' || kingAlp > 'H' || kingNum < 1 || kingNum > 8) {
				kingAlp -= alpha;
				kingNum -= num;
				continue;
			}
			
//			움직인 king과 stone이 같은 위치에 있는지 체크
			if(kingAlp == stoneAlp && kingNum == stoneNum) {
				stoneAlp += alpha;
				stoneNum += num;
				
				if(stoneAlp < 'A' || stoneAlp > 'H' || stoneNum < 1 || stoneNum > 8) {
					stoneAlp -= alpha;
					stoneNum -= num;
					kingAlp -= alpha;
					kingNum -= num;
					continue;
				}
			}
		}
		sb.append(kingAlp).append(kingNum).append("\n").append(stoneAlp).append(stoneNum);
		System.out.println(sb);
	}
}
