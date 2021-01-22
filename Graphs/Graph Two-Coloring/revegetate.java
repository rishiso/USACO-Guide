import java.io.*;
import java.util.*;

public class revegetate {
	
	static ArrayList<ArrayList<Edge>> edges = new ArrayList<ArrayList<Edge>>();
	static int[] graph;
	static boolean works = true;
	
	static class Edge {
		int f;
		String p;
		Edge(int f, String p) {
			this.f = f;
			this.p = p;
		}
	}
	
	static void DFS(int current, int color) {
		graph[current] = color;
		for(Edge e: edges.get(current)) {
			if (graph[e.f] == color && (e.p).equals("D")) {
				works = false;
			} else if (graph[e.f] == color * -1 && (e.p).equals("S")) {
				works = false;
			} else if (graph[e.f] == 0 && (e.p).equals("S")) {
				DFS(e.f, color);
			} else if (graph[e.f] == 0 && (e.p).equals("D")) {
				DFS(e.f, color * -1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("revegetate.out"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			edges.add(new ArrayList<Edge>());
		}
				
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			edges.get(a).add(new Edge(b, s));
			edges.get(b).add(new Edge(a, s));
		}
		
		graph = new int[N];		
		
		int components = 0;
		for(int i = 0; i < N; i++) {
			if (graph[i] == 0) {
				DFS(i, 1);
				components++;
			}
		}
		
		if (!works) {
			pw.println(0);
		} else {
			pw.print(1);
			for(int i = 0; i < components; i++) {
				pw.print(0);
			}
			pw.println();
		}
		
		pw.close();
	} 

}
