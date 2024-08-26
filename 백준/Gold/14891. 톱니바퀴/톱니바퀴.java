import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static String first;
	static String second;
	static String third;
	static String fourth;
	public static void main(String[] args) throws IOException {
		first = bf.readLine();
		second = bf.readLine();
		third = bf.readLine();
		fourth = bf.readLine();
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int K = Integer.parseInt(st.nextToken());
		for(int i=0; i<K; i++) {
			input();
		}
		
		int result = 0;
		if(first.charAt(0) == '1') result += 1;
		if(second.charAt(0) == '1') result += 2;
		if(third.charAt(0) == '1') result += 4;
		if(fourth.charAt(0) == '1') result += 8;
		
		System.out.println(result);
	}

	private static void input() throws IOException {
		
		String[] input = bf.readLine().split(" ");
		
		int wheel = Integer.parseInt(input[0]);
		int dir = Integer.parseInt(input[1]);
		
		char left = '0';
		char right = '0';
		
		if(wheel == 1) {
			left = first.charAt(2);
			
			changeWheel1(dir);
			
			//1번째 바퀴, 2번째 바퀴 비교
			if(left != second.charAt(6)) {
				
				//2번째 바퀴, 3번째 바퀴 비교
				if(second.charAt(2) != third.charAt(6)) {
					
					//3번째 바퀴, 4번째 바퀴 비교
					if(third.charAt(2) != fourth.charAt(6)) {
						changeWheel4(dir*-1);
					}
					
					changeWheel3(dir);
				}
				
				changeWheel2(dir*-1);
			}
			
		}else if(wheel == 2) {
			left = second.charAt(6);
			right = second.charAt(2);
			
			changeWheel2(dir);
			
			//2번째 바퀴, 1번째 바퀴 비교
			if(left != first.charAt(2)) {
				changeWheel1(dir*-1);
			}
			
			//2번째 바퀴, 3번째 바퀴 비교
			if(right != third.charAt(6)) {
				
				//3번째 바퀴, 4번째 바퀴 비교
				if(third.charAt(2) != fourth.charAt(6)) {
					changeWheel4(dir);
				}
				
				changeWheel3(dir*-1);
			}
			
		}else if(wheel == 3) {
			left = third.charAt(6);
			right = third.charAt(2);
			
			changeWheel3(dir);
			
			//3번째 바퀴, 4번째 바퀴 비교
			if(right != fourth.charAt(6)) {
				changeWheel4(dir*-1);
			}
			
			//3번째 바퀴, 2번째 바퀴 비교
			if(left != second.charAt(2)) {
				
				//2번째 바퀴, 1번째 바퀴 비교
				if(second.charAt(6) != first.charAt(2)) {
					changeWheel1(dir);
				}
				
				changeWheel2(dir*-1);
			}
			
		}else {
			right = fourth.charAt(6);
			changeWheel4(dir);
			
			//4번째 바퀴, 3번째 바퀴 비교
			if(right != third.charAt(2)) {
				
				//3번째 바퀴, 2번째 바퀴 비교
				if(third.charAt(6) != second.charAt(2)) {
					
					//2번째 바퀴, 1번째 바퀴 비교
					if(second.charAt(6) != first.charAt(2)) {
						changeWheel1(dir*-1);
					}
					
					changeWheel2(dir);
				}
				
				changeWheel3(dir*-1);
			}
		}
	}

	private static void changeWheel1(int dir) {
		if(dir == 1) {
			first = first.charAt(7) + first.substring(0,7);
		}else {
			first = first.substring(1,8) + first.charAt(0);
		}
	}
	
	private static void changeWheel2(int dir) {
		if(dir == 1) {
			second = second.charAt(7) + second.substring(0,7);
		}else {
			second = second.substring(1,8) + second.charAt(0);
		}
	}
	
	private static void changeWheel3(int dir) {
		if(dir == 1) {
			third = third.charAt(7) + third.substring(0,7);
		}else {
			third = third.substring(1,8) + third.charAt(0);
		}
	}
	
	private static void changeWheel4(int dir) {
		if(dir == 1) {
			fourth = fourth.charAt(7) + fourth.substring(0,7);
		}else {
			fourth = fourth.substring(1,8) + fourth.charAt(0);
		}
	}
}