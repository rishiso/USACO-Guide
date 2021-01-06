import java.io.*;
import java.util.*;

public class socdist {
	
	static long[][] intervals;
	
	static boolean check(int n, int m, long d) {
		
		long prev = Long.MIN_VALUE;
		int count = 0;
		
		for(int i = 0; i < m; i++) {
			while(Math.max(prev + d, intervals[i][0]) <= intervals[i][1]) {
				prev = Math.max(prev + d, intervals[i][0]);
				count++;
				if (count == n) return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("socdist.out"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		intervals = new long[M][2];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			intervals[i][0] = Long.parseLong(st.nextToken());
			intervals[i][1] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(intervals,
				Comparator.comparingLong(a -> a[0]));
		
		long left = 1;
		long right = intervals[M - 1][1];
		
		long solution = 0;
        
        while(left <= right) {
			long mid = (left + right) / 2;
			if (check(N, M, mid)) {
				left = mid + 1;
				solution = mid;
			} else {
				right = mid - 1;
			}
		}
        
        pw.println(solution);
        System.out.println(solution);
        
        pw.close();
        br.close();
		
	}

}
