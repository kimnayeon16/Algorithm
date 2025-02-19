import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int Q = Integer.parseInt(bf.readLine());
			for(int q=0; q<Q; q++) {
				st = new StringTokenizer(bf.readLine());
				String input = st.nextToken();
				int num =Integer.parseInt(st.nextToken());
				
				if(input.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				}else {
					if(map.size() == 0) continue;
					
					int n;
					if(num == 1) {
						n = map.lastKey();
					}else {
						n = map.firstKey();
					}
					if(map.put(n, map.get(n)-1)==1) {
						map.remove(n);
					}
				}
				
			}
			if(map.size() == 0) {
				System.out.println("EMPTY");
			}else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}
	}
}