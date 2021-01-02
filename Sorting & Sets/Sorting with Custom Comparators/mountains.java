import java.io.*;
import java.util.*;

public class mountains {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] mountains = new int[N][2];
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	mountains[i][0] = Integer.parseInt(st.nextToken());
        	mountains[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(mountains,
        		Comparator.comparingInt(a -> a[0]));
        
        for(int[] e: mountains) {
        	System.out.println(Arrays.toString(e));
        }
                
        int solution = 0;
        
        for(int i = 0; i < N; i++) {
        	int iL = i - 1;
        	int iR = i + 1;
        	boolean works = true;
        	
    		while(iL >= 0 && works) {
    			if (mountains[iL][1] >= mountains[i][1]) {
    				int a = mountains[i][0] - mountains[iL][0];
    				int b = mountains[iL][1] - mountains[i][1];
    				if (b >= a) {
    					works = false;
    				}
    			}
    			iL--;
    		} 
        	
    		while(iR < N && works) {
	    		if (mountains[iR][1] >= mountains[i][1]) {	
    				int a = mountains[iR][0] - mountains[i][0];
	    			int b = mountains[iR][1] - mountains[i][1];
	    			if (b >= a) {
	    				works = false;
	    			}
	    		}
    			iR++;
        	}
    		
    		if (works) solution++;
        }
        
        System.out.println(solution);
        pw.println(solution);
        
        br.close();
        pw.close();
	}

}
