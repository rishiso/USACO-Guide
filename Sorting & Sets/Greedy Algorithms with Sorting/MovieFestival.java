import java.io.*;
import java.util.*;

public class MovieFestival {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] movies = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			movies[i][0] = Integer.parseInt(st.nextToken());
			movies[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(movies, 
				Comparator.comparingInt(a -> a[1]));
		
		int solution = 0;
		int current = 0;
		
		for(int i = 0; i < n; i++) {
			if (movies[i][0] >= current) {
				current = movies[i][1];
				solution++;
			}
		}
		
		System.out.println(solution);

	}

}
