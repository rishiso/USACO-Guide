//The solution is optimal according to the USACO Guide, but java is simply too slow for 1 second test cases.

import java.io.*;
import java.util.*;

public class MovieFestival2 {
	
	static TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();

	public static void main(String[] args) throws IOException {
		
		Long start = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] movies = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			movies[i][0] = Integer.parseInt(st.nextToken());
			movies[i][1] = Integer.parseInt(st.nextToken());
		}
				
		Arrays.sort(movies, 
				Comparator.comparingInt(a -> a[1]));
				
		for(int i = 0; i < k; i++) {
			add(0);
		}
		
		int solution = 0;
		for(int i = 0; i < n; i++) {
			Integer s = multiset.floorKey(movies[i][0]);
			if (s != null) {
				remove(s);
				add(movies[i][1]);
				solution++;
			}
		}
		
		System.out.println(solution);
		
		System.out.println(System.currentTimeMillis() - start);
	}
	
	static void add(int x){
	    if(multiset.containsKey(x)){
	        multiset.put(x, multiset.get(x) + 1);
	    } else {
	        multiset.put(x, 1);
	    }
	}

	static void remove(int x){
	    multiset.put(x, multiset.get(x) - 1);
	    if(multiset.get(x) == 0){
	        multiset.remove(x);
	    }
	}

}
