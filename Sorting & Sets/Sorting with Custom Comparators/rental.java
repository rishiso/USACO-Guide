import java.io.*;
import java.util.*;

public class rental {
	
	public static void sort(int[] l) {
		Arrays.sort(l);
		for(int i = 0; i < l.length-1-i; i++) {
			l[i] ^= l[l.length-1-i];
			l[l.length-1-i] ^= l[i];
			l[i] ^= l[l.length-1-i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("rental.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[] cows = new int[N];
        
        for(int i = 0; i < N; i++) {
        	cows[i] = Integer.parseInt(br.readLine());
        }
        
        int[][] stores = new int[M][2];
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	stores[i][0] = Integer.parseInt(st.nextToken());
        	stores[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int[] rentals = new int[R];
        
        for(int i = 0; i < R; i++) {
        	rentals[i] = Integer.parseInt(br.readLine());
        }
        
        sort(rentals);
        Arrays.sort(stores, 
        		Comparator.comparingInt(a -> -a[1]));
        sort(cows);
        
        long[] maxProfit = new long[N + 1];
        int index = 0;
        
        for(int i = 0; i < N; i++) {
        	maxProfit[i + 1] = maxProfit[i];
        	while(index < M && cows[i] > 0) {
        		int used = Math.min(stores[index][0], cows[i]);
        		maxProfit[i+1] += (long) used * stores[index][1];
        		cows[i] -= used;
        		stores[index][0] -= used;
        		if (stores[index][0] == 0) {
        			index++;
        		}
        	}
        }
        
        int a = N - 1;
        int rI = 0;
        long rentalSoFar = 0;
        while(a >= 0 && rI < R) {
        	rentalSoFar += rentals[rI];
        	maxProfit[a] += rentalSoFar;
        	rI++;
        	a--;
        }
        
        long solution = Long.MIN_VALUE;
        
        for(long s: maxProfit) {
        	solution = Math.max(solution, s);
        }
        
        System.out.println(solution);
        pw.println(solution);
        
        pw.close();
        br.close();
	}

}
