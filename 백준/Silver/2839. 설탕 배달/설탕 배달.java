import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//5의 배수로 나누어떨어지는가?
		A : if(N % 5 == 0) {
			System.out.println(N/5);
		}else if(N % 5 != 0) {
			int count = 0;
			for(int i=N-3; i>0; i-=3) {
				count++;
				if(i % 5 == 0) {
					System.out.println(i/5 + count);
					break A;
				}
			}
			if(N % 3 == 0) {
				System.out.println(N/3);
			}else {
				System.out.println(-1);
			}
		}
	}
}
