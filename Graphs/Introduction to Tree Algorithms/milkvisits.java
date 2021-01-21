import java.io.*;
import java.util.*;

public class milkvisits {
	
	static ArrayList<ArrayList<Integer>> roads = new ArrayList<ArrayList<Integer>>();
	static int[] components;
	
	static void DFS(int start, int current, String[] farms) {
		if (farms[current].equals(farms[start])) {
			components[current] = start;
			
			for(int i: roads.get(current)) {
				if (components[i] == -1) {
					DFS(start, i, farms);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("milkvisits.out"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] farms = br.readLine().split("");
		
		for(int i = 0; i < N; i++) {
			roads.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			roads.get(a).add(b);
			roads.get(b).add(a);
		}
		
		components = new int[N];
		Arrays.fill(components, -1);
		
		for(int i = 0; i < N; i++) {
			if (components[i] == -1) DFS(i, i, farms);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			String p = st.nextToken();
			
			if (components[a] != components[b]) {
				System.out.print(1);
				pw.print(1);
			} else if (farms[a].equals(p)) {
				System.out.println(1);
				pw.print(1);
			} else {
				System.out.println(0);
				pw.print(0);
			}
		}
		
		System.out.println();
		pw.println();
		
		pw.close();
		br.close();
	}

}
