import java.io.*;
import java.util.*;

public class angry {
	
	static boolean simulate(int r, int[] haybales, int n, int k) {
		
		int start = 0;
		
		while(k > 0) {
			int temp = start;
			for(int i = start; i < n; i++) {
				if (haybales[start] + (2 * r) >= haybales[i]) {
					temp++;
				} else {
					break;
				}
			}
			start = temp;
			k--;
		}
		return(start >= n);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] haybales = new int[N];
        
        for(int i = 0; i < N; i++) {
        	haybales[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(haybales);
        
        int left = 1;
		int right = 1000000000;
		
		int solution = 0;
        
        while(left <= right) {
			int mid = (left + right) / 2;
			if (!simulate(mid, haybales, N, K)) {
				left = mid + 1;
			} else {
				right = mid - 1;
				solution = mid;
			}
		}
        
        System.out.println(solution);
        pw.println(solution);
        
        br.close();
        pw.close();
	}

}
