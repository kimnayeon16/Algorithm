import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static char[] sign = {'+', '-', ' '};
	static char[] choice;
	static int N;
	static StringBuilder form = new StringBuilder();
	static StringBuilder sb = new StringBuilder();
	static List<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int n=0; n<T; n++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken()); 
			nums = new int[N];
			choice = new char[N-1];
			list = new ArrayList<String>();
			for(int i=0; i<N; i++) {
				nums[i] = i+1;
			}
			findSumZero(0);
			Collections.sort(list);
			for(int i=0; i<list.size(); i++) {
				sb.append(list.get(i)).append('\n');
			}
			if(n != T-1) {
				sb.append('\n');				
			}
		}
		System.out.println(sb);
		
	}
	private static void findSumZero(int depth) {
		if(depth == N-1) {
			if(sumNums()) {
				list.add(form.reverse().toString());
			}
			
			return;
		}
		
		for(int i=0; i<3; i++) {
			choice[depth] = sign[i];
			findSumZero(depth+1);
			form.delete(0, form.length());
		}
	}
	private static boolean sumNums() {
		int sum = 0;
		int num = N;
		String blank = "";
		form.append(num);
		
		for(int i=N-2; i>=0; i--) {
			
			if(choice[i] == '+') {
				if(!blank.equals(" ")) {
					sum += Integer.parseInt(Integer.toString(num--) + blank);
					blank = "";
				}else {
					sum += num--;			
				}
			}else if(choice[i] == '-') {
				if(!blank.equals(" ")) {
					sum -= Integer.parseInt(Integer.toString(num--) + blank);
					blank = "";
				}else {
					sum -= num--;					
				}
			}else if(choice[i] == ' ') {
				blank = Integer.toString(num--) + blank;
			}
			form.append(choice[i]).append(num);
		}
		
		if(choice[0] != ' ') {
			sum += 1;
		}else {
			sum += Integer.parseInt(1+blank);
		}
		
		if(sum == 0) {
			return true;
		}else {
			return false;
		}
	}
}