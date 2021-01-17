import java.io.*;
import java.util.*;

public class maxcross {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("maxcross.out"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		boolean[] broken = new boolean[N];
		
		for(int i = 0; i < B; i++) {
			broken[Integer.parseInt(br.readLine()) - 1] = true;
		}
		
		int[] prefixes = new int[N];
		int s = 0;
		
		for(int i = 0; i < N; i++) {
			if (!broken[i]) s++;
			prefixes[i] = s;
		}
		
		int solution = prefixes[K - 1];
		
		for(int i = 1; i <= N - K; i++) {
			int x = prefixes[i + K - 1] - prefixes[i - 1];
			solution = Math.min(solution, K - x);
		}
		
		System.out.println(solution);
		pw.println(solution);
		
		br.close();
		pw.close();
	}

}
