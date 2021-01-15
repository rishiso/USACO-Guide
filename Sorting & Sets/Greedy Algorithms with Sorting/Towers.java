import java.io.*;
import java.util.*;

public class Towers {
	
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
	
	static TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int solution = 0;
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if (multiset.isEmpty() || multiset.lastKey() <= x) {
				solution++;
				add(x);
			} else {
				remove(multiset.higherKey(x));
				add(x);
			}			
		}
		
		System.out.println(solution);	
	}
}
