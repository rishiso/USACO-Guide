import java.io.*;
import java.util.*;

public class SumTwoValues {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] original = nums.clone();
		Arrays.sort(nums);
		
		int a = 0;
		int b = n - 1;
		
		while(nums[a] + nums[b] != s && b > a) {
			if (nums[a] + nums[b] > s) b--;
			else a++;
		}
		
		if (b == a) {
			System.out.println("IMPOSSIBLE");
		} else {
			int x = 0;
			int y = 0;
			for(int i = 0; i < n; i++) {
				if (original[i] == nums[a]) {
					x = i + 1;
					break;
				}
			}
			
			for(int i = 0; i < n; i++) {
				if (original[i] == nums[b] && i + 1 != x) {
					y = i + 1;
					break;
				}
			}
			
			System.out.println(x + " " + y);
		}
	}

}
