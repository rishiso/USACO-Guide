//Java isn't sufficient for 1 second test cases, but an optimal solution

import java.io.*;
import java.util.*;

public class TrafficLights {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> gaps = new PriorityQueue<Integer>(Collections.reverseOrder());
		gaps.add(x);
		
		TreeSet<Integer> lights = new TreeSet<Integer>();
		lights.add(0);
		lights.add(x);
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int light = Integer.parseInt(st.nextToken());
			
			int u = lights.higher(light);
			int l = lights.lower(light);
			lights.add(light);
			
			gaps.remove(u - l);
			gaps.add(u - light);
			gaps.add(light - l);
			
			System.out.print(gaps.peek());
			if (i < n - 1) System.out.print(" ");
		}
	}

}
