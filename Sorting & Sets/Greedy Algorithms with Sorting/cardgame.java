import java.io.*;
import java.util.*;

public class cardgame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cardgame.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("cardgame.out"));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cards = new int[2 * N];
		
		int[] elsie = new int[N];
		
		for(int i = 0; i < 2 * N; i++) {
			cards[i] = i + 1;
		}
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			elsie[i] = x;
			cards[x - 1] = -1;
		}
		
		TreeSet<Integer> cardsA = new TreeSet<Integer>();
		TreeSet<Integer> cardsB = new TreeSet<Integer>();
		
		Arrays.sort(cards);
		int count = 0;
		for(int i = 0; i < 2 * N; i++) {
			if (count < N / 2 && cards[i] != -1) {
				cardsB.add(cards[i]);
				count++;
			} else if (cards[i] != -1) {
				cardsA.add(cards[i]);
			}
		}
		
		int score = 0;
		for(int i = 0; i < N / 2; i++) {
			if (cardsA.last() > elsie[i]) {
				cardsA.remove(cardsA.higher(elsie[i]));
				score++;
			} else {
				cardsA.remove(cardsA.first());
			}
		}
		
		for(int i = N / 2; i < N; i++) {
			if (cardsB.first() < elsie[i]) {
				cardsB.remove(cardsB.lower(elsie[i]));
				score++;
			} else {
				cardsB.remove(cardsB.last());
			}
		}
		
		System.out.println(score);
		pw.println(score);
		
		pw.close();
		br.close();
 	}

}
