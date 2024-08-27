import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] nx = {-1, 0, 1, 0};
	static int[] ny = {0, 1, 0, -1};
	
	static int[] answer = new int[2];
	
	public static class Node{
		private int x;
		private int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		//입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(bf.readLine());
			String s = st.nextToken();
			for(int c=0; c<C; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
		//bfs
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != '#' && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		//출력
		System.out.println(answer[0] + " " + answer[1]);
	}

	private static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<Node>();
	
		queue.add(new Node(x,y));
		visited[x][y] = true;
		
		int sheep = 0;
		int wolf = 0;
		
		if(map[x][y] == 'o') sheep++;
		if(map[x][y] == 'v') wolf++;
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			for(int d=0; d<4; d++) {
				int dx = nx[d] + tmp.x;
				int dy = ny[d] + tmp.y;
				
				if(0<=dx && dx<R && 0<=dy && dy<C && !visited[dx][dy]) {
					if(map[dx][dy] == 'o') sheep++;
					if(map[dx][dy] == 'v') wolf++;
					
					if(map[dx][dy] != '#') {
						queue.add(new Node(dx,dy));
						visited[dx][dy] = true;
					}
				}
			}
		}
		if(sheep > wolf) answer[0] += sheep;
		else answer[1] += wolf;
	}
}