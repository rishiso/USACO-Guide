import java.io.*;
import java.util.*;

public class fenceplan {
	
	static ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
	static int[][] cows;
	static boolean[] used, usedComponent;
	static int minX, maxX, minY, maxY;
	
	static void DFS(int currentNode) {
		used[currentNode] = true;
		usedComponent[currentNode] = true;
		minX = Math.min(minX, cows[currentNode][0]);
		minY = Math.min(minY, cows[currentNode][1]);
		maxX = Math.max(maxX, cows[currentNode][0]);
		maxY = Math.max(maxY, cows[currentNode][1]);
		for(int i: edges.get(currentNode)) {
			if (!used[i]) {
				DFS(i);
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        cows = new int[N][2];
        
        for(int i = 0; i < N; i++) {
        	edges.add(new ArrayList<Integer>());
        	
        	st = new StringTokenizer(br.readLine());
        	cows[i][0] = Integer.parseInt(st.nextToken());
        	cows[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken()) - 1;
        	int b = Integer.parseInt(st.nextToken()) - 1;
        	
        	edges.get(a).add(b);
        	edges.get(b).add(a);
        }
        
        int smallestPerimeter = Integer.MAX_VALUE;
        used = new boolean[N];
        usedComponent = new boolean[N];
                
        for(int i = 0; i < N; i++) {
        	if (!usedComponent[i]) {
	        	Arrays.fill(used, false);
	        	minX = Integer.MAX_VALUE;
	        	minY = Integer.MAX_VALUE;
	        	maxX = Integer.MIN_VALUE;
	        	maxY = Integer.MIN_VALUE;
	        	DFS(i);
	        	int p = 2 * ((maxX - minX) + (maxY - minY));
	        	smallestPerimeter = Math.min(smallestPerimeter, p);
        	}
        }
        
        System.out.println(smallestPerimeter);
        pw.println(smallestPerimeter);
        
        br.close();
        pw.close();
	}

}
