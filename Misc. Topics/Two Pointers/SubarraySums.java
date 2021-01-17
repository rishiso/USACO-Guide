import java.io.*;
import java.util.*;

public class SubarraySums {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int right = 0;
		long sum = a[0];
		
		long solution = 0;
		
		while(sum < x && right < n - 1) {
			right++;
			sum += a[right];
		}
		
		if (sum == x) {
			solution++;
		}
		
		for(int i = 0; i < n; i++) {
			sum -= a[i];
			while(sum < x && right < n - 1) {
				right++;
				sum += a[right];
			}
			
			if (sum == x) {
				solution++;
			}
		}
		
		System.out.println(solution);

	}

}
