import java.io.*;
import java.util.*;

public class FactoryMachines {
	
	static boolean run(long[] machines, long req, long time) {
		long made = 0;
		
		for(int i = 0; i < machines.length; i++) {
			made += time / machines[i];
			if (made >= req) break;
		}
		
		return(made >= req);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long t = Long.parseLong(st.nextToken());
		
		long[] m = new long[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			m[i] = Long.parseLong(st.nextToken());
		}
		
		long left = 0;
		long right = Long.MAX_VALUE;

		long solution = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			if (run(m, t, mid)) {
				right = mid - 1;
				solution = mid;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(solution);
	}

}
