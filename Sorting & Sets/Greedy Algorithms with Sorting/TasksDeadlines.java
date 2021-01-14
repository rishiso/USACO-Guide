import java.io.*;
import java.util.*;

public class TasksDeadlines {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] tasks = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tasks[i][0] = Integer.parseInt(st.nextToken());
			tasks[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tasks, 
				Comparator.comparingInt(a -> a[0]));
		
		long reward = 0;
		long currentTime = 0;
		
		for(int i = 0; i < N; i++) {
			currentTime += tasks[i][0];
			reward += tasks[i][1] - currentTime;
		}
		
		System.out.println(reward);
	}

}
