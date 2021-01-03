import java.io.*;

public class perimeter {
	
	static int N;
	static boolean[][] used;
	static boolean[][] grid;
	
	static int area;
	static int perimeter;
	
	static void floodFill(int x, int y) {
		area++;
		used[x][y] = true;
		
		if (x == N - 1) perimeter++;
		if (x == 0) perimeter++;
		if (y == N - 1) perimeter++;
		if (y == 0) perimeter++;
		
		if (x < N - 1) {
			if (!grid[x + 1][y]) {
				perimeter++;
			} else if (!used[x + 1][y]) {
				floodFill(x + 1, y);
			}
		}
		
		if (x > 0) {
			if (!grid[x - 1][y]) {
				perimeter++;
			} else if (!used[x - 1][y]) {
				floodFill(x - 1, y);
			}
		}
		
		if (y < N - 1) {
			if (!grid[x][y + 1]) {
				perimeter++;
			} else if (!used[x][y + 1]) {
				floodFill(x, y + 1);
			}
		}
		
		if (y > 0) {
			if (!grid[x][y - 1]) {
				perimeter++;
			} else if (!used[x][y - 1]) {
				floodFill(x, y - 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        
        N = Integer.parseInt(br.readLine());
        
        grid = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
        	String[] s = br.readLine().split("");
        	for(int j = 0; j < N; j++) {
        		if (s[j].equals("#")) {
        			grid[i][j] = true;
        		}
        	}
        }
        
        used = new boolean[N][N];
        
        int maxArea = Integer.MIN_VALUE;
        int currentPerimeter = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if (!used[i][j] && grid[i][j]) {
        			perimeter = 0;
        			area = 0;
        			floodFill(i, j);
        			
        			if (area > maxArea) {
        				maxArea = area;
        				currentPerimeter = perimeter;
        			} else if (area == maxArea && perimeter < currentPerimeter) {
        				currentPerimeter = perimeter;
        			}
        		}
        	}
        }
        
        pw.print(maxArea);
        pw.print(" ");
        pw.println(currentPerimeter);
        
        br.close();
        pw.close();
	}

}
