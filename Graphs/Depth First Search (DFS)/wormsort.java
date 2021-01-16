import java.io.*;
import java.util.*;

public class wormsort {
	
	static ArrayList<ArrayList<Edge>> wormholes = new ArrayList<ArrayList<Edge>>();
	static boolean[] used;
	
	static void DFS(int current, int weight) {
		used[current] = true;
		
		for(Edge e: wormholes.get(current)) {
			if (!used[e.d] && e.w >= weight) {
				DFS(e.d, weight);
			}
		}		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cows = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			cows[i] = Integer.parseInt(st.nextToken()) - 1;
			wormholes.add(new ArrayList<Edge>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			
			wormholes.get(a).add(new Edge(b, w));
			wormholes.get(b).add(new Edge(a, w));
		}
		
		boolean sorted = true;
		int firstWrong = 0;
		
		for(int i = 0; i < N; i++) {
			if (cows[i] != i) {
				sorted = false;
				firstWrong = i;
				break;
			}
		}
		
		if (sorted) {
			System.out.println(-1);
			pw.println(-1);
		} else {
			int left = 0;
			int right = 1000000000;
			
			int solution = 0;
	        
	        while(left <= right) {
	        	
				int mid = (left + right) / 2;
				used = new boolean[N];
				DFS(firstWrong, mid);
				
				boolean works = true;
				
				for(int i = 0; i < N; i++) {
					if (!used[i] && cows[i] != i) {
						works = false;
						break;
					}
				}
				
				if (works) {
					left = mid + 1;
					solution = mid;
				} else {
					right = mid - 1;
				}
			}
	        
	        System.out.println(solution);
	        pw.println(solution);
		}
		
		br.close();
		pw.close();
	}
		
	static class Edge {
	    int d, w;
	    public Edge(int d, int w) {
	      this.d = d;
	      this.w = w;
	    }
	  }
}
