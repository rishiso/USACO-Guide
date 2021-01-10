//WORKS ON 8/11 TEST CASES ONLY

import java.io.*;
import java.util.*;

public class Towers {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		SortedSet<Integer> towers = new TreeSet<Integer>();
		
		int solution = 0;
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if (towers.isEmpty() || towers.last() <= x) {
				solution++;
				towers.add(x);
			} else {
				for(int j: towers) {
					if (j > x) {
						towers.remove(j);
						towers.add(x);
						break;
					}
				}
			}
		}
		
		System.out.println(solution);
		
	}

}
