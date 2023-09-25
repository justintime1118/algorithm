import java.util.*;

class Prac {

    static int[] nums;
    static int[] seq = new int[3];
    static boolean[] isUsed;
    static int ans;

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
        isUsed = new boolean[n];
        ans = 0;

        pick(0, 0);

        System.out.println(ans);
    }

    public static void pick(int k, int limit) {
        if (k == 3) {
            int tmp = 0;

            for (int i = 0; i < 3; i++)
                tmp += seq[i];
            if (tmp == 0)
                ans++;

            return ;
        }

        for (int i = limit; i < nums.length; i++) {
            if (isUsed[i] == true)
                continue ;
            isUsed[i] = true;
            seq[k] = nums[i];
            pick(k + 1, i + 1);
            isUsed[i] = false;
        }
    }
}