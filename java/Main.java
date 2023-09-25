import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		char c = 0;
		int cnt = 0;
		for (int i = 0; i < line.length() - 1; i++) {
			if (line.charAt(i) == 'b' && line.charAt(i + 1) == 'a')
				cnt++;
		}
		System.out.println(cnt);
	}
}