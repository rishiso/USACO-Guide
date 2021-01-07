import java.io.*;
import java.util.*;

public class lightson {
	
	static int[][] switches;
	static boolean[][] isOn;
	static boolean[][] used;
	static boolean[][] lightsSwitched;
	
	static void DFS(int x, int y, int n, int m) {
		used[x][y] = true;
		
		if (!lightsSwitched[x][y]) {
			lightsSwitched[x][y] = true;
			for(int i = 0; i < m; i++) {
				if (switches[i][0] == x && switches[i][1] == y) {
					
					int a = switches[i][2];
					int b = switches[i][3];
					
					isOn[a][b] = true;
					
					if (a > 0 && used[a - 1][b]) {
						DFS(a - 1, b, n, m);
					}
					
					if (b > 0 && used[a][b - 1]) {
						DFS(a, b - 1, n, m);
					}
					
					if (a < n - 1 && used[a + 1][b]) {
						DFS(a + 1, b, n, m);
					}
					
					if (b < n - 1 && used[a][b + 1]) {
						DFS(a, b + 1, n, m);
					}
				}
			}
		}
		
		if (x > 0 && isOn[x - 1][y] && !used[x - 1][y]) {
			DFS(x - 1, y, n, m);
		}
		
		if (y > 0 && isOn[x][y - 1] && !used[x][y - 1]) {
			DFS(x, y - 1, n, m);
		}
		
		if (x < n - 1 && isOn[x + 1][y] && !used[x + 1][y]) {
			DFS(x + 1, y, n, m);
		}
		
		if (y < n - 1 && isOn[x][y + 1] && !used[x][y + 1]) {
			DFS(x, y + 1, n, m);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("lightson.out"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		switches = new int[M][4];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				switches[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		
		isOn = new boolean[N][N];
		isOn[0][0] = true;
		
		used = new boolean[N][N];
		lightsSwitched = new boolean[N][N];
		
		DFS(0, 0, N, M);
		
		int solution = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (isOn[i][j]) {
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
