import java.io.*;
import java.util.*;

public class moocast {
	
	static ArrayList<ArrayList<Integer>> proximity = new ArrayList<ArrayList<Integer>>();
	static boolean[] used;
	
	static int DFS(int currentNode) {
		int count = 1;
		used[currentNode] = true;
		
		for(int i: proximity.get(currentNode)) {
			if (!used[i]) {
				count += DFS(i);
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] cows = new int[N][3];
        
        for(int i = 0; i < N; i++) {
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	cows[i][0] = Integer.parseInt(st.nextToken());
        	cows[i][1] = Integer.parseInt(st.nextToken());
        	cows[i][2] = Integer.parseInt(st.nextToken());
        	cows[i][2] *= cows[i][2];
        	
        	proximity.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		int distance = (cows[i][0] - cows[j][0]) * (cows[i][0] - cows[j][0]) + (cows[i][1] - cows[j][1]) * (cows[i][1] - cows[j][1]);
        		if (i != j && distance < cows[i][2]) {
        			proximity.get(i).add(j);
        		}
        	}
        }
        
        used = new boolean[N]; 
        int highestCount = Integer.MIN_VALUE;
        
        for(int i = 0; i < N; i++) {
        	Arrays.fill(used, false);
        	highestCount = Math.max(highestCount, DFS(i));
        }
        
        System.out.println(highestCount);
        pw.println(highestCount);
        
        br.close();
        pw.close();
        
	} 

}
