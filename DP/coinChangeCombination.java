import java.util.Arrays;
import java.util.Scanner;

public class coinChangeCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        int[] dp = new int[amt+1];
        dp[0]=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if(j>=arr[i])
                    dp[j]+=dp[j-arr[i]];
            }
        }
    //  System.out.println(Arrays.toString(dp));   
     System.out.println(dp[amt]);   
    }
}