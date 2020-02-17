import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine();
		String b = scan.nextLine();
		int indexa = 0;
		int indexb = 0;
		while (indexa < a.length() && indexb < b.length()) {
			if (a.charAt(indexa) == b.charAt(indexb)) {
				indexb++;
			}
			indexa++;
		}
		if (indexb == b.length()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
    }
}
