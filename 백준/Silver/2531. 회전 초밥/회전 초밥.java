import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //접시의 수
		int d = sc.nextInt(); //초밥의 가짓수
		int k = sc.nextInt(); //연속해서 먹는 접시의 수
		int c = sc.nextInt(); //쿠폰 번호
		
		int[] sushiBelt = new int[N];
		int[] sushi = new int[d+1];
		int count = 0;
		int max = 0;
		
		//배열리스트에 회전 초밥 벨트에 놓인 접시 번호 추가하기
		for(int i=0; i<N; i++) {
			sushiBelt[i] = sc.nextInt();
		}
		
		//처음 최소 접시 k개에 대해 체크
		for(int j=0; j<k; j++) {
			if(sushi[sushiBelt[j]] == 0) {
				count++;
			}
			sushi[sushiBelt[j]]++;
		}
		max = count;
		
		
		for(int n=0; n<N; n++) {
			//count의 값이 커졌다는 것은 초밥의 종류가 변경되었다는 것.
			//쿠폰 접시가 빠진거라면 count에 추가해줘야함.
			if(count >= max) {
				if(sushi[c] == 0) {
					max = count+1;
				}else {
					max = count;
				}
			}
			
			//k개의 접시 중 첫번째 접시 빼기
			sushi[sushiBelt[n]]--;
			if(sushi[sushiBelt[n]] == 0) count--;
			
			//하나 뺏으니까 접시 하나 넣기
			if(sushi[sushiBelt[(n + k) % N]] == 0) count++;
			sushi[sushiBelt[(n + k) % N]]++;
		}
		//출력
		System.out.println(max);
	}
}