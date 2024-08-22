import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> bob = new ArrayList<>();
		
		int N = sc.nextInt(); //접시의 수
		int d = sc.nextInt(); //초밥의 가짓수
		int k = sc.nextInt(); //연속해서 먹는 접시의 수
		int c = sc.nextInt(); //쿠폰 번호
		int result = 0;
		
		//배열리스트에 회전 초밥 벨트에 놓인 접시 번호 추가하기
		for(int i=0; i<N; i++) {
			bob.add(sc.nextInt());
		}
		
		
		for(int i=0; i<N; i++) {
			int[] count = new int[d+1];
			int bobCount = 0;
			
			//벨트에 초밥이 있다면 +1
			for(int j=0; j<k; j++) {
				count[bob.get((i+j) % N)]++;
			}
			
			//초밥 쿠폰
			count[c]++;
			
			//만약 0이 아니라면 초밥이 있는 것이므로 카운트 증가
			for(int a=1; a<=d; a++) {
				if(count[a] != 0) {
					bobCount++;
				}
			}
			//최댓값 비교
			result = Math.max(result, bobCount);
		}
		//출력
		System.out.println(result);
	}
}