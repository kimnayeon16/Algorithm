import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[][] map;
	static List<Node> teacher = new ArrayList<>();
	static boolean ans = false;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(bf.readLine());
		 
		 N = Integer.parseInt(st.nextToken());
		 map = new char[N][N];
		 
		 for(int i=0; i<N; i++) {
			 String input = bf.readLine();
			 for(int j=0; j<N; j++) {
				 map[i][j] = input.charAt(j*2);
				 
				 if(map[i][j] == 'T') {
					 teacher.add(new Node(i,j));
				 }
			 }
		 }
		 
		 findSeat(0);
		 System.out.println(ans ? "YES" : "NO");

	}
	private static void findSeat(int depth) {
		if(depth == 3) {
			if(checkTeacher()) {
				ans = true;
			}
			return;
		}
		
		for(int a=0; a<N*N; a++) {
			int i = a/N;
			int j = a%N;
	
			if(map[i][j] == 'X') {
				map[i][j] = 'O';
				findSeat(depth+1);
				map[i][j] = 'X';
			}
			
		}
		
	}
	private static boolean checkTeacher() {
		for(int i=0; i<teacher.size(); i++) {
			int x = teacher.get(i).x;
			int y = teacher.get(i).y;
			
			for(int d=0; d<4; d++) {
				int n = 1;
				while(true) {
					int nx = dx[d]*n + x;
					int ny = dy[d]*n + y;
					
					if(0>nx || nx>=N || 0>ny || ny>=N) break;
					
					if(map[nx][ny] == 'S') {
						return false;//학생이라면
					}else if(map[nx][ny] == 'O'){ //장애물이라면
						break;
					}
					n++;
				}
			}
		}
		return true;
	}
}