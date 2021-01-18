import java.io.*;
import java.util.*;

public class moocastG {
	
	static boolean[] used;
	static Point[] cows;
	
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void DFS(int maxD, int current) {
		used[current] = true;
		
		for(int i = 0; i < cows.length; i++) {
			int a = cows[current].x - cows[i].x;
			int b = cows[current].y - cows[i].y;
			if (!used[i] && a * a + b * b <= maxD) {
				DFS(maxD, i);
			}
		}
	}
	
	static boolean isFilled() {
		for(int i = 0; i < used.length; i++) {
			if (!used[i]) return false;
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("moocast.out"));
		
		int N = Integer.parseInt(br.readLine());
		
		cows = new Point[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			cows[i] = new Point(x, y);
		}
		
		int left = 0;
		int right = Integer.MAX_VALUE;

		int solution = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			used = new boolean[N];
			DFS(mid, 0);
			if (isFilled()) {
				right = mid - 1;
				solution = mid;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(solution);
		pw.println(solution);
		
		pw.close();
		br.close();
	}

}
