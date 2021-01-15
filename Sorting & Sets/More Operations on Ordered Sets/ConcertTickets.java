//The solution is optimal according to the USACO Guide, but java is simply too slow for 1 second test cases.

import java.io.*;
import java.util.*;

public class ConcertTickets {

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> tickets = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			tickets.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(tickets);
		
		st = new StringTokenizer(br.readLine());
	
		for(int i = 0; i < m; i++) {
			int maxPrice = Integer.parseInt(st.nextToken());
			
			int t = Collections.binarySearch(tickets, maxPrice);
			
			if (t == -1) {
				System.out.println(-1);
			} else if (t < 0) {
				t = Math.abs(t + 2);
				System.out.println(tickets.get(t));
				tickets.remove(t);
			} else {
				System.out.println(tickets.get(t));
				tickets.remove(t);
			}
			
		}		
	}

}
