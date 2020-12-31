import java.io.*;
import java.util.*;

public class mootube {
	
	static ArrayList<ArrayList<int[]>> pairs = new ArrayList<ArrayList<int[]>>();
		
	static boolean[] used;
		
	static int DFS(int k, int current, int minRelevance) {
		used[current] = true;
		
		int count = 0;
		
		for(int[] i: pairs.get(current)) {
			if (!used[i[0]]) {
				int m = Math.min(minRelevance, i[1]);
				if (m >= k) {
					count++;
				}
				count += DFS(k, i[0], m);
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
        	pairs.add(new ArrayList<int[]>());
        }
        
        for(int i = 0; i < N - 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken()) - 1;
        	int b = Integer.parseInt(st.nextToken()) - 1;
        	int c = Integer.parseInt(st.nextToken());
        	
        	pairs.get(a).add(new int[] {b,c});
        	pairs.get(b).add(new int[] {a,c});
        }
        
        used = new boolean[N];
         
        for(int i = 0; i < Q; i++) {
        	Arrays.fill(used, false);
        	st = new StringTokenizer(br.readLine());
        	int k = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken()) - 1;
        	        	
        	
        	int count = DFS(k, v, Integer.MAX_VALUE);
        	
        	System.out.println(count);
        	pw.println(count);
        }
        
        br.close();
        pw.close();
	}

}
