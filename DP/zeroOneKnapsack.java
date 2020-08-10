import java.util.Arrays;
import java.util.Scanner;

public class zeroOneKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        int cap = sc.nextInt();

        int[] dp = new int[cap + 1];
        //Using O(n) space complexity. IN class were told O(n^2) space complexity which was not accepted by gfg
        for (int i = 0; i < n; i++) {
            for (int j = cap; j >= wt[i]; j--) {
                dp[j]=Math.max(dp[j - wt[i]]+val[i],dp[j]);
            }
        }
        System.out.println(dp[cap]);
       // System.out.println(Arrays.toString(dp));
    }
}