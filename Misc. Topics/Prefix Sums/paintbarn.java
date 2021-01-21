import java.io.*;
import java.util.*;

public class paintbarn {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("paintbarn.out"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] barn = new int[1001][1001];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) + 1;
			int b = Integer.parseInt(st.nextToken()) + 1;
			int c = Integer.parseInt(st.nextToken()) + 1;
			int d = Integer.parseInt(st.nextToken()) + 1;
			
			barn[a][b]++;
			barn[c][d]++;
			barn[a][d]--;
			barn[c][b]--;
		}
		
		int solution = 0;
		for(int i = 1; i < 1001; i++) {
			for(int j = 1; j < 1001; j++) {
				barn[i][j] += barn[i - 1][j] + barn[i][j - 1] - barn[i - 1][j - 1];
				if (barn[i][j] == K) {
					solution++;
				}
			}
		}
		
		System.out.println(solution);
		pw.println(solution);
		
		pw.close();
		br.close();
	}

}
