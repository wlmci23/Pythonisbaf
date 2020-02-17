import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long v = scan.nextLong();
		long count = 0;
		for (long i = 0; i < n; i++) {
			if (scan.nextLong() <= v) {
				count++;
			}
		}
		System.out.println(((long)1<<count)-1);
    }
}
