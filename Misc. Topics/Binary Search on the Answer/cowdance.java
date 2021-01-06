import java.io.*;
import java.util.*;

public class cowdance {
	
	static int N;
	static int[] cows;
	
	static int simulate(int K) {
		
		int[] stage = new int[K];
		
		for(int i = 0; i < K; i++) {
			stage[i] = cows[i];
		}
		
		int index = K;
		int time = 0;
		
		while(index < N) {
			int timeRemaining = Integer.MAX_VALUE;
			for(int i = 0; i < K; i++) {
				timeRemaining = Math.min(timeRemaining, stage[i]);
			}
			
			time += timeRemaining;
			
			for(int i = 0; i < K; i++) {
				stage[i] -= timeRemaining;
				if (stage[i] == 0) {
					stage[i] = cows[index];
					index++;
				}
			}
		}
		
		int t = Integer.MIN_VALUE;
		
		for(int i = 0; i < K; i++) {
			t = Math.max(t, stage[i]);
			
		}
		
		return time + t;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        cows = new int[N];
        
        for(int i = 0; i < N; i++) {
        	cows[i] = Integer.parseInt(br.readLine());
        }
        
        int left = 1;
        int right = N;
        
        while(left != right) {
        	int mid = (left + right) / 2;
        	if (simulate(mid) <= T) {
        		right = mid;
        	} else {
        		left = mid + 1;
        	}
        }
        
        System.out.println(left);
        pw.println(left);
        
        br.close();
        pw.close();
	}

}
