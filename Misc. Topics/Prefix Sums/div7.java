//This solutions only receives 8/10 test cases.
//The other two test cases time out.

import java.io.*;

public class div7 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] nums = new int[N];
        
        for(int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(br.readLine());
        }
        
        int solution = 0;
        		
        for(int i = 0; i < N; i++) {
        	long s = 0;
        	for(int j = i; j < N; j++) {
        		s += nums[j];
        		if (s % 7 == 0 && j - i + 1 > solution) {
        			solution = j - i + 1;
        		}
        	}
        }
        
        System.out.println(solution);
        pw.println(solution);
        
        pw.close();
        br.close();
	}

}
