import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*

for the output: (don't need to minimize m)
print m (length of new array) and the new array itself

- every sub-array of length k should have the same set of numbers
- we can insert before the 1st or after the n-th number
- it's impossible if there are more distinct numbers than k
- inserted numbers must be between 1 and n (inclusive)

4 2
1 2 2 1
= 1 2 1 2 1

4 3
1 2 2 1
= 1 2 1 1 2 1

3 2
1 2 3
= 1 2 3 (impossible)

4 4
4 3 4 2
= 4 3 4 2

9 3
3 3 3 2 1 2 2 3 2
(1 2) 3 (1 2) 3 (1 2) 3 (1) 2 (3) 1 (2 3) (1) 2 (3) (1) 2 (3) (1 2) 3 (1) 2 (3)

4 3
4 3 4 2
(2 3) 4 (2) 3 (4) (2 3) 4 2 (3 4)

4 3
1 3 1 2

 */

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt(), k = fs.nextInt();
			int[] a = fs.readArray(n);
			TreeSet<Integer> ts = new TreeSet<>();
			for (int i = 0; i < n; i++) {
				ts.add(a[i]);
			}
			if (ts.size() > k) {
				out.println(-1);
				continue;
			}
			for (int i = 1; i <= n; i++) {
				if (ts.size() < k && !ts.contains(i)) {
					ts.add(i);
				}
			}
			out.println(ts.size() * n);
			for (int i = 0; i < n; i++) {
				for (int x : ts) {
					out.print(x + " ");
				}
			}
			out.println();
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newIndex = rnd.nextInt(n);
			int temp = a[newIndex]; //change this
			a[newIndex] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
