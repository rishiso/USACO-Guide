import java.io.*;
import java.util.*;

public class bcount {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("bcount.out"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] a = new int[N + 1];
		int[] b = new int[N + 1];
		int[] c = new int[N + 1];
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 1) {
				a[i]++;
			}
			
			if (x == 2) {
				b[i]++;
			}
			
			if (x == 3) {
				c[i]++;
			}
			
			a[i + 1] = a[i];
			b[i + 1] = b[i];
			c[i + 1] = c[i];
		}
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			if (x != 0) {
				pw.print(a[y] - a[x - 1]);
				pw.print(" ");
				pw.print(b[y] - b[x - 1]);
				pw.print(" ");
				pw.println(c[y] - c[x - 1]);
			} else {
				pw.print(a[y]);
				pw.print(" ");
				pw.print(b[y]);
				pw.print(" ");
				pw.println(c[y]);
			}
		}
		
		pw.close();
		br.close();
	}

}
