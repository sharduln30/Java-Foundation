import java.util.Arrays;
import java.util.Scanner;

public class fibDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp=new int[n+1];
        dp[0]=0;
        if (n==0) {
            System.out.println(n);
            return;
        }
        
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);

    }
}