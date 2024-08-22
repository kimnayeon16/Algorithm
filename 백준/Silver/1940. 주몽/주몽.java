import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] nums = new int[N];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		int left = 0;
		int right = nums.length-1;
		
		while(left < right) {
			if(nums[left] + nums[right] == M) {
				cnt++;
				left++;
				right--;
			}else {
				if(nums[left] + nums[right] < M) {
					left++;
				}else {
					right--;
				}
			}
		}
		System.out.println(cnt);
	}

}